package com.stack.dao.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntityService<T> {

    ResponseEntity<T> findById(Long id);

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> save(T entity);

    ResponseEntity<T> update(T entity);

    ResponseEntity<String> delete(T entity);
}
