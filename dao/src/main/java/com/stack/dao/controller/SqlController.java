package com.stack.dao.controller;

import com.stack.dao.entity.Album;
import com.stack.dao.model.BaseEntity;
import com.stack.dao.model.QueryRequest;
import com.stack.dao.model.SqlQuery;
import com.stack.dao.repository.SqlParser;
import com.stack.dao.service.AlbumSqlService;
import com.stack.dao.service.ArtistSqlService;
import com.stack.dao.service.SqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/query")
public class SqlController {

    private final SqlParser parser;
    private final AlbumSqlService albumSqlService;
    private final ArtistSqlService artistSqlService;

    @PostMapping("/albums/select")
    public ResponseEntity<List<Album>> getAlbum(
            @RequestBody QueryRequest request) {
        return albumSqlService.select(request.getSql());
    }

    @PostMapping("/albums/insert")
    public ResponseEntity<Void> addAlbum(
            @RequestBody QueryRequest request) {
        return albumSqlService.insert(request.getSql());
    }

    @PostMapping("/select")
    public ResponseEntity<? extends List<? extends BaseEntity>> getEntities(@RequestBody QueryRequest request) {
        String sql = request.getSql();
        SqlQuery query = parser.parseSql(sql);
        SqlService<? extends BaseEntity> service =
                switch (query.getTableName()) {
                    case "Album" -> albumSqlService;
                    case "Artist" -> artistSqlService;
                    default -> throw new IllegalArgumentException("Invalid table name: " + query.getTableName());
                };
        return service.select(sql);
    }
}
