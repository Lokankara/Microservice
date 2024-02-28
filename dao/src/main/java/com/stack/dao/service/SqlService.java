package com.stack.dao.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SqlService<T> {

    ResponseEntity<List<T>> select(String sql);

    ResponseEntity<Void> insert(String sql);
}
