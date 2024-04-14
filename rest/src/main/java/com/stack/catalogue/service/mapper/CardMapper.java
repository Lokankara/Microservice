package com.stack.catalogue.service.mapper;

import com.stack.catalogue.model.dto.BaseDto;
import com.stack.catalogue.model.dto.PostCard;
import com.stack.catalogue.model.entity.Card;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardMapper {

    public BaseDto toDto(Card card) {
        if (card == null) {
            return null;
        }
        return PostCard.builder()
                       .id(card.getId())
                       .name(card.getName())
                       .url(card.getUrl())
                       .description(card.getDescription())
                       .build();
    }

    public Card toEntity(PostCard dto) {
        if (dto == null) {
            return null;
        }
        return Card.builder()
                   .name(dto.getName())
                   .url(dto.getUrl())
                   .description(dto.getDescription())
                   .build();
    }

    public Iterable<BaseDto> toListDto(List<Card> cardList) {
        return cardList.stream()
                .map(this::toDto)
                .toList();
    }
}
