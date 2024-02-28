package com.stack.dao.repository;

import com.stack.dao.entity.Artist;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SqlArtistDao
        extends SqlDao<Artist> {

    @Override
    protected Artist getEntity(ResultSet resultSet)
            throws SQLException {
        return Artist.builder()
                     .artistId(resultSet.getInt("ArtistId"))
                     .name(resultSet.getString("Name"))
                     .build();
    }
}
