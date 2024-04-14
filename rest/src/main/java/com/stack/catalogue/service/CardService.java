package com.stack.catalogue.service;

import com.stack.catalogue.model.dto.BaseDto;
import com.stack.catalogue.model.dto.PostCard;
import org.springframework.http.ResponseEntity;

public interface CardService {

    ResponseEntity<BaseDto> createCard(PostCard card);

    Iterable<BaseDto> findAll();

    ResponseEntity<BaseDto> findById(Integer id);

    Iterable<BaseDto> findByPartialName(String partialName);
}
