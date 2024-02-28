package com.stack.dao.controller;

import com.stack.dao.entity.Album;
import com.stack.dao.model.QueryRequest;
import com.stack.dao.service.SqlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SqlControllerServiceTest {

    SqlService<Album> mockService;

    @BeforeEach
    public void setup() {
        mockService = mock(SqlService.class);
    }

    @Test
    void testGetAlbum() {

        SqlController controller = new SqlController(mockService);
        String sqlQuery = "SELECT * FROM albums";
        List<Album> albums = new ArrayList<>();
        when(mockService.select(sqlQuery)).thenReturn(ResponseEntity.ok(albums));
        ResponseEntity<List<Album>> response = controller.getAlbum(new QueryRequest(sqlQuery));
        verify(mockService).select(sqlQuery);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(albums, response.getBody());
    }

    @Test
    void testAddAlbum() {
        SqlController controller = new SqlController(mockService);
        String sqlQuery = "INSERT INTO albums (title, artist) VALUES ('Test Album', 'Test Artist')";
        when(mockService.insert(sqlQuery)).thenReturn(ResponseEntity.ok().build());
        ResponseEntity<Void> response = controller.addAlbum(new QueryRequest(sqlQuery));
        verify(mockService).insert(sqlQuery);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
