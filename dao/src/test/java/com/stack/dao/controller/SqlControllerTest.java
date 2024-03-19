package com.stack.dao.controller;

import com.stack.dao.entity.Album;
import com.stack.dao.service.AlbumSqlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SqlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumSqlService mockService;

    @BeforeEach
    public void setup() {
        reset(mockService);
    }

    @Test
    void testGetAlbum() throws Exception {
        String sqlQuery = "SELECT * FROM albums";
        List<Album> albums = new ArrayList<>();

        when(mockService.select(sqlQuery)).thenReturn(ResponseEntity.ok(albums));
        mockMvc.perform(post("/query/albums/select")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"sql\": \"" + sqlQuery + "\"}"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$").isArray());

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockService).select(captor.capture());
        assertEquals(sqlQuery, captor.getValue());
    }

    @Test
    void testAddAlbum() throws Exception {
        String sqlQuery = "INSERT INTO albums (title, artist) VALUES ('Test Album', 'Test Artist')";

        when(mockService.insert(sqlQuery)).thenReturn(ResponseEntity.ok().build());

        mockMvc.perform(post("/query/albums/insert")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"sql\": \"" + sqlQuery + "\"}"))
               .andExpect(status().isOk());

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockService).insert(captor.capture());
        assertEquals(sqlQuery, captor.getValue());
    }
}
