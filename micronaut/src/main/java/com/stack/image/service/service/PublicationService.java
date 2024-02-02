package com.stack.image.service.service;

import com.image.service.dao.PublicationRepository;
import com.image.service.model.PublicationEntity;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class PublicationService {

    PublicationRepository publicationRepository;

    public List<PublicationEntity> getAllPublications() {
        return publicationRepository.findAll();
    }
}
