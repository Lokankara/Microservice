package com.stack.dao.service;

import com.stack.dao.entity.Album;
import com.stack.dao.exception.EntityNotFoundException;
import com.stack.dao.repository.Dao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlbumService
        implements EntityService<Album> {

    private final Dao<Album> dao;

    @Override
    public ResponseEntity<Album> findById(Long id) {
        return dao.findById(id)
                .map(album -> ResponseEntity.ok().body(album))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public ResponseEntity<List<Album>> findAll() {
        return ResponseEntity.ok().body(dao.findAll());
    }

    @Override
    public ResponseEntity<Album> save(Album album) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dao.save(album));
    }

    @Override
    public ResponseEntity<Album> update(Album album) {
        return ResponseEntity.ok().body(dao.update(album));
    }

    @Override
    public ResponseEntity<String> delete(Album album) {
        dao.delete(album);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Album deleted successfully.");
    }
}
