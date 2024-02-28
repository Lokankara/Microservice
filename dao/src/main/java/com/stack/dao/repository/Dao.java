package com.stack.dao.repository;

import com.stack.dao.service.ConnectionPool;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    ConnectionPool POOL = ConnectionPool.getInstance();

    Optional<T> findById(Long id);

    List<T> findAll();

    T save(T t);

    T update(T t);

    void delete(T t);
}
