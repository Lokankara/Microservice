package com.stack.controller;

import com.stack.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@RequestMapping("customer/product")
public class ProductController {

    private final ProductClient productClient;

    @GetMapping("list")
    public Mono<String> getProductsList(
            Model model,
            @RequestParam(name = "filter", required = false) String filter) {
        model.addAttribute("filter", filter);
        return this.productClient.findAllProducts(filter)
                                 .collectList()
                                 .doOnNext(products -> model.addAttribute(
                                         "products", products))
                                 .thenReturn("customer/product/list");
    }
}
