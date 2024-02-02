package com.stack.image.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class PublicationEntity {

    @Id
    private Long id;

    private String name;
}
