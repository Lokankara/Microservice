package com.stack.dao.repository;

import com.stack.dao.entity.Album;
import com.stack.dao.exception.AlbumException;
import com.stack.dao.exception.SqlArgumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.stack.dao.repository.Dao.POOL;

@Slf4j
@Repository
public class SQLAlbumDao
        implements SQLDao<Album> {

    @Override
    public List<Album> select(@NonNull String sql) {
        if (!isValidSql(sql)) {
            throw new SqlArgumentException("Invalid SQL query, there suspicious Keywords");
        }
        List<Album> albums = new ArrayList<>();
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            boolean isResultSet = statement.execute();

            if (isResultSet) {
                try (ResultSet resultSet = statement.getResultSet()) {
                    while (resultSet.next()) {
                        albums.add(getAlbum(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new AlbumException(e.getMessage());
        }
        return albums;
    }


    @Override
    public int insert(String sql) {
        if (!isValidSql(sql)) {
            throw new SqlArgumentException("Invalid SQL query, there suspicious Keywords");
        }
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            return statement.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new AlbumException(e.getMessage());
        }
    }

    private boolean isValidSql(String sql) {
        String[] suspiciousKeywords = {"DROP", "DELETE", "TRUNCATE"};
        for (String keyword : suspiciousKeywords) {
            if (sql.toUpperCase().contains(keyword)) {
                return false;
            }
        }
        return true;
    }

    private Album getAlbum(ResultSet resultSet)
            throws SQLException {
        return Album.builder()
                    .albumId(resultSet.getInt("AlbumId"))
                    .title(resultSet.getString("Title"))
                    .artistId(resultSet.getInt("ArtistId"))
                    .build();
    }
}
