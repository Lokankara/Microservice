package com.stack.dao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stack.dao.entity.Album;
import com.stack.dao.exception.EntityException;
import com.stack.dao.service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLException;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private AlbumService service;

    private final String urlTemplate = "/albums";

    private Album album;

    @BeforeEach
    public void setup() {
        album = Album.builder()
                     .title("Abbey Road")
                     .artistId(100)
                     .albumId(100500)
                     .build();
    }

    @Test
    void testGetAllAlbums()
            throws Exception {
        mockMvc.perform(get(urlTemplate).contentType(APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testAddAlbum()
            throws Exception {
        mockMvc.perform(post(urlTemplate)
                                .contentType(APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album)))
               .andExpect(status().isOk())
               .andDo(print());
    }

    @Test
    void testAddAlbumSQLException() throws Exception {
        Album album = new Album();
        when(service.save(album)).thenThrow(new SQLException(
                "Creating album failed, no rows affected."));

        mockMvc.perform(post(urlTemplate)
                                .contentType(APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album)))
               .andExpect(status().isInternalServerError());
    }

    @Test
    void testAddAlbumAlbumException() throws Exception {
        Album album = new Album();
        when(service.save(album)).thenThrow(new EntityException(
                "Field 'AlbumId' doesn't have a default value"));

        mockMvc.perform(post(urlTemplate)
                                .contentType(APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album)))
               .andExpect(status().isInternalServerError());
    }

    @Test
    void testGetAlbumById()
            throws Exception {
        int id = 1;
        mockMvc.perform(get(urlTemplate+ "/{id}", id)
                                .contentType(APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testUpdateAlbum()
            throws Exception {
        mockMvc.perform(put(urlTemplate)
                                .contentType(APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album)))
               .andExpect(status().isOk());
    }

    @Test
    void testDeleteAlbum()
            throws Exception {
        mockMvc.perform(delete(urlTemplate)
                                .contentType(APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album)))
               .andExpect(status().isOk());
    }
}
