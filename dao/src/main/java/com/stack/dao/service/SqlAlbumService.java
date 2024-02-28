package com.stack.dao.service;

import com.stack.dao.entity.Album;
import com.stack.dao.repository.SQLDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class SqlAlbumService
        implements SqlService<Album> {

    private final SQLDao<Album> dao;

    @Override
    public ResponseEntity<List<Album>> select(String sql) {
        return ResponseEntity.ok(dao.select(sql));
    }

    @Override
    public ResponseEntity<Void> insert(String sql) {
        return dao.insert(sql) > 0
               ? ResponseEntity.ok().build()
               : ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
    }
}
