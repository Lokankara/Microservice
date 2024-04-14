package com.stack.catalogue.dao;

import com.stack.catalogue.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p from Product p where p.title ilike :filter")
    Iterable<Product> findAllByTitleLikeIgnoreCase(@Param("filter") String filter);

    Page<Product> findByTitleContaining(String filter, Pageable pageable);
}
