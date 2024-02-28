package com.stack.dao.repository;

import java.util.List;

public interface SQLDao<T> {

    List<T> select(String sql);

    int insert(String sql);
}
