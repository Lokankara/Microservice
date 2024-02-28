package com.stack.dao.repository;

import com.stack.dao.exception.EntityException;
import com.stack.dao.exception.SqlArgumentException;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.stack.dao.repository.Dao.POOL;

@Slf4j
public abstract class SqlDao<T> {

    protected abstract T getEntity(ResultSet resultSet) throws SQLException;

    public List<T> select(String sql){
        if (isInvalidSql(sql)) {
            throw new SqlArgumentException("Invalid SQL query, there suspicious Keywords");
        }
        List<T> result = new ArrayList<>();
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            if (statement.execute()) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while (resultSet.next()) {
                        result.add(getEntity(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new EntityException(e.getMessage());
        }
        return result;
    }

    public int insert(String sql) {
        if (isInvalidSql(sql)) {
            throw new SqlArgumentException("Invalid SQL query, there suspicious Keywords");
        }
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            return statement.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new EntityException(e.getMessage());
        }
    }

    private boolean isInvalidSql(String sql) {
        String[] suspiciousKeywords = {"DROP", "DELETE", "TRUNCATE",  "--"};
        return Arrays.stream(suspiciousKeywords)
                     .anyMatch(keyword -> sql.toUpperCase().contains(keyword));
    }
}
