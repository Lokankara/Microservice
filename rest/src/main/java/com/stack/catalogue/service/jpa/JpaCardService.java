package com.stack.catalogue.service.jpa;

import com.stack.catalogue.dao.CardRepository;
import com.stack.catalogue.model.dto.BaseDto;
import com.stack.catalogue.model.dto.PostCard;
import com.stack.catalogue.model.entity.Card;
import com.stack.catalogue.service.CardService;
import com.stack.catalogue.service.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaCardService
        implements CardService {

    private final CardRepository dao;
    private final CardMapper mapper;

    @Override
    public ResponseEntity<BaseDto> createCard(PostCard card) {
        return ResponseEntity.ok(mapper.toDto(
                dao.save(mapper.toEntity(card))));
    }

    @Override
    public Iterable<BaseDto> findAll() {
        return mapper.toListDto(dao.findAll());
    }

    @Override
    public ResponseEntity<BaseDto> findById(Integer id) {
        return ResponseEntity.ok(mapper.toDto(
                dao.findById(id).orElse(
                        new Card(0, "", "", ""))));
    }

    @Override
    public Iterable<BaseDto> findByPartialName(String partialName) {
        return mapper.toListDto(
                dao.findByNameContaining(partialName));
    }
}
