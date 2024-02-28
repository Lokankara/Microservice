package com.stack.dao.service;

import com.stack.dao.model.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SqlService<T extends BaseEntity> {
    ResponseEntity<List<T>> select(String sql);

    ResponseEntity<Void> insert(String sql);
}
