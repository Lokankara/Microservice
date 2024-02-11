package com.stack.dao.controller;

import com.stack.dao.entity.Album;
import com.stack.dao.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/albums")
public class AlbumController {

    private final EntityService<Album> service;

    @GetMapping()
    public ResponseEntity<List<Album>> getAllAlbums() {
        return service.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Album> addAlbum(
            @RequestBody Album album) {
        return service.save(album);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(
            @PathVariable(value = "id") long id) {
        return service.findById(id);
    }

    @PutMapping("")
    public ResponseEntity<Album> updateAlbum(Album album) {
        return service.update(album);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAlbum(Album album) {
        return service.delete(album);
    }
}
