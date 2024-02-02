package com.stack.image.service.dao;

import com.stack.image.service.model.PublicationEntity;
import io.micronaut.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("default")
public interface PublicationRepository
        extends CrudRepository<PublicationEntity, Long> {

    List<PublicationEntity> findAllOrderByName();
}
