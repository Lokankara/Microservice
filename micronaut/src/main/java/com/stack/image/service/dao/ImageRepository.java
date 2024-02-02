package com.stack.image.service.dao;

import com.stack.image.service.model.ImageEntity;
import io.micronaut.data.repository.CrudRepository;

public interface ImageRepository
        extends CrudRepository<ImageEntity, Long> {
}
