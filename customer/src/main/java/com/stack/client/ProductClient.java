package com.stack.client;

import com.stack.customer.Product;
import reactor.core.publisher.Flux;

public interface ProductClient {

    Flux<Product> findAllProducts(String filter);
}
