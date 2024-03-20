package com.stack.catalogue.controller;

import com.stack.catalogue.model.BaseDto;
import com.stack.catalogue.model.PostProductPayload;
import com.stack.catalogue.model.Product;
import com.stack.catalogue.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/products/{productId:\\d+}")
public class ProductRestController {

    private final ProductService service;

    @ModelAttribute("product")
    public Product product(
            @PathVariable("productId") int productId) {
        return this.service.findProductById(productId)
                           .orElseThrow(() -> new NoSuchElementException(
                                   "catalogue.errors.product.not_found"));
    }

    @GetMapping
    public Product findProduct(
            @ModelAttribute("product") Product product) {
        return product;
    }

    @PatchMapping
    public ResponseEntity<BaseDto> updateProduct(
            @PathVariable("productId") int productId,
            @Valid @RequestBody PostProductPayload payload,
            BindingResult bindingResult)
            throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            return ResponseEntity.ok().body(this.service.updateProduct(productId, payload));
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("productId") int productId) {
        this.service.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
