package com.stack.dao.repository;

import com.stack.dao.entity.Album;
import com.stack.dao.exception.AlbumException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class AlbumDao
        implements Dao<Album> {

    @Override
    public List<Album> findAll() {
        List<Album> albums = new ArrayList<>();
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM Album");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                albums.add(getAlbum(resultSet));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new AlbumException(e.getMessage());
        }
        return albums;
    }

    @Override
    public Optional<Album> findById(Long id) {
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Album WHERE AlbumId = ?")) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next()
                       ? Optional.of(getAlbum(resultSet))
                       : Optional.empty();
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new AlbumException(e.getMessage());
        }
    }

    public Album save(Album album) {
        String checkSql = "SELECT * FROM Album WHERE Title = ?";
        String getLastIdSql = "SELECT MAX(AlbumId) FROM Album";
        String insertSql = "INSERT INTO Album (Title, ArtistId, AlbumId) VALUES (?, ?, ?)";
        try (Connection connection = POOL.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(checkSql)) {
            prepareStatement.setString(1, album.getTitle());
            ResultSet resultSet = prepareStatement.executeQuery();
            if (!resultSet.next()) {
                try (PreparedStatement prepared = connection.prepareStatement(getLastIdSql);
                     ResultSet lastIdRs = prepared.executeQuery()) {
                    int lastId = 0;
                    if (lastIdRs.next()) {
                        lastId = lastIdRs.getInt(1);
                    }
                    album.setAlbumId(lastId+1);
                    try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
                        statement.setString(1, album.getTitle());
                        statement.setLong(2, album.getArtistId());
                        statement.setLong(3, album.getAlbumId());
                        int affectedRows = statement.executeUpdate();
                        if (affectedRows == 0) {
                            throw new SQLException("Creating album failed, no rows affected.");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            throw new AlbumException(ex.getMessage());
        }
        return album;
    }

    @Override
    public Album update(Album entity) {
        String sql = "UPDATE Album SET Title = ?, ArtistId = ? WHERE AlbumId = ?";
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getTitle());
            statement.setLong(2, entity.getArtistId());
            statement.setLong(3, entity.getAlbumId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0
                   ? entity
                   : null;
        } catch (SQLException e) {
            log.error(e.getSQLState());
            throw new AlbumException(e.getMessage());
        }
    }


    @Override
    public void delete(Album album) {
        Connection connection = POOL.getConnection();
        String sql = "DELETE FROM Album WHERE AlbumId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, album.getAlbumId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new AlbumException(e.getMessage());
        }
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
