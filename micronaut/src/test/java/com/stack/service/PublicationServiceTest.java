package com.stack.service;

import com.stack.image.service.model.PublicationEntity;
import com.stack.image.service.service.PublicationService;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class PublicationServiceTest {

    @Inject
    private PublicationService publicationService;

    @Inject
    @Client("/")
    private HttpClient httpClient;

//    @Test
    void getPublications() {
        PublicationEntity publication = new PublicationEntity();
        List<PublicationEntity> publicationEntities =
                Collections.singletonList(publication);
        when(publicationService.getAllPublications()).thenReturn(
                publicationEntities);
        HttpRequest<Object> request = HttpRequest.GET("/publications");
        HttpResponse<List<PublicationEntity>> rsp = httpClient
                .toBlocking()
                .exchange(request, Argument.listOf(PublicationEntity.class));

        assertEquals(HttpStatus.OK, rsp.getStatus());
        assertNotNull(rsp.body());
        List<PublicationEntity> actual = rsp.body();
        assertNotNull(actual);
        assertEquals(publicationEntities.size(), actual.size());
    }

    @MockBean(PublicationService.class)
    PublicationService publicationService() {
        return mock(PublicationService.class);
    }
}
