package com.stack.catalogue.dao;

import com.stack.catalogue.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository
        extends JpaRepository<Card, Integer> {

    List<Card> findByNameContaining(String partialName);
}
