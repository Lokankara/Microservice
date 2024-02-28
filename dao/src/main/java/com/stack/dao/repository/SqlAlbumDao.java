package com.stack.dao.repository;

import com.stack.dao.entity.Album;
import com.stack.dao.exception.EntityException;
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
public class SqlAlbumDao extends SqlDao<Album> {

    protected Album getEntity(ResultSet resultSet)
            throws SQLException {
        return Album.builder()
                    .albumId(resultSet.getInt("AlbumId"))
                    .title(resultSet.getString("Title"))
                    .artistId(resultSet.getInt("ArtistId"))
                    .build();
    }
}
