package com.stack.image.service.dao;

import com.stack.image.service.model.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;
import java.util.Collection;

@Repository
public class CustomerRepository {

    private final JdbcClient jdbcClient;

    public CustomerRepository(DataSource dataSource) {
        jdbcClient = JdbcClient.create(dataSource);
    }

    RowMapper<Customer> customerRowMapper =
            (rs, i) -> new Customer(rs.getInt("id"), rs.getString("name"));


    Collection<Customer> customerCollection() {
        return this.jdbcClient.sql("""
                select * from customer
                """).query(customerRowMapper).list();
    }
}
