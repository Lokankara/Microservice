package com.stack.image.service.controller;

import com.image.service.model.PublicationEntity;
import com.image.service.service.PublicationService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/publications")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @Get
    public List<PublicationEntity> getPublications() {
        return publicationService.getAllPublications();
    }
}
