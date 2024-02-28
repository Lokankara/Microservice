package com.stack.dao.service;

import com.stack.dao.entity.Artist;
import com.stack.dao.repository.SqlArtistDao;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
@AllArgsConstructor
public class SqlArtistService implements ArtistSqlService{

    private final SqlArtistDao dao;
    @Override
    public ResponseEntity<List<Artist>> select(String sql) {
        return ResponseEntity.ok(dao.select(sql));
    }

    @Override
    public ResponseEntity<Void> insert(String sql) {
        return dao.insert(sql) > 0
               ? ResponseEntity.ok().build()
               : ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
    }
}
