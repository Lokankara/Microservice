package com.stack.catalogue.controller;

import com.stack.catalogue.model.BaseDto;
import com.stack.catalogue.model.PostProductPayload;
import com.stack.catalogue.model.Product;
import com.stack.catalogue.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("catalogue-api/products")
public class ProductsRestController {

    private final ProductService service;

    public ProductsRestController(
            @Qualifier("jpaProductService")
            ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Product> findAllProducts() {
        return service.findAllProducts("");
    }

    @PostMapping
    public ResponseEntity<BaseDto> createProduct(
            @Valid @RequestBody PostProductPayload payload,
            UriComponentsBuilder builder,
            BindingResult bindingResult)
            throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            return service.createProduct(payload, builder);
        }
    }

    @GetMapping("/id")
    public Product findProduct(@ModelAttribute("product") Product product) {
        return product;
    }
}
