package com.stack.dao.repository;

import com.stack.dao.entity.Album;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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
