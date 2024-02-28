package com.stack.dao.service;

import com.stack.dao.entity.Album;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumSqlService
        extends SqlService<Album> {
    ResponseEntity<List<Album>> select(String sql);

    ResponseEntity<Void> insert(String sql);
}
