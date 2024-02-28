package com.stack.dao.controller;

import com.stack.dao.entity.Album;
import com.stack.dao.model.QueryRequest;
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
@RequestMapping("/query/albums")
public class SqlController {

    private final SqlService<Album> service;

    @PostMapping("/select")
    public ResponseEntity<List<Album>> getAlbum(
            @RequestBody QueryRequest request) {
        return service.select(request.getSql());
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> addAlbum(
            @RequestBody QueryRequest request) {
        return service.insert(request.getSql());
    }
}
