package com.stack.catalogue.controller;

import com.stack.catalogue.model.dto.BaseDto;
import com.stack.catalogue.model.dto.PostCard;
import com.stack.catalogue.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cards")
public class CardController {

    private final CardService service;

    @PostMapping
    public ResponseEntity<BaseDto> createCard(
            @RequestBody PostCard cardDto) {
      log.info(cardDto.toString());
        return service.createCard(cardDto);
    }

    @GetMapping
    public Iterable<BaseDto> findAllCards() {
        return service.findAll();
    }

    @GetMapping("{id:\\d+}")
    public ResponseEntity<BaseDto> findCardById(
            @PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<BaseDto>> findCardsByPartialName(
            @RequestParam("name") String partialName) {
        return ResponseEntity.ok(service.findByPartialName(partialName));
    }
}
