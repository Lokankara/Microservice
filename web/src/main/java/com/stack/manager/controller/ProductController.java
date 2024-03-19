package com.stack.manager.controller;

import com.stack.manager.model.Product;
import com.stack.manager.model.ProductPayload;
import com.stack.manager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "list")
    public String getProductsList(Model model){
        model.addAttribute("products", this.productService.findAll());
        return "catalogue/products/list";
    }

    @GetMapping(value = "create")
    public String getNewProductPage(){
        return "catalogue/products/add";
    }

    @PostMapping(value = "create")
    public String createNewProductPage(ProductPayload payload){
        Product product = this.productService.create(payload);
        return "redirect:/catalogue/products/list";
    }

    @GetMapping(value = "{productId:\\d+}")
    public String getProduct(@PathVariable("productId") int productId, Model model){
        Product product = this.productService.findById(productId).orElseThrow();
        model.addAttribute("product", product);
        return "catalogue/products/product";
    }
}
