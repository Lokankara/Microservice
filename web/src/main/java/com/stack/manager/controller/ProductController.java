package com.stack.manager.controller;

import com.stack.manager.exception.BadRequestException;
import com.stack.manager.model.PostProductPayload;
import com.stack.manager.model.Product;
import com.stack.manager.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping(("catalogue/products/{productId:\\d+}"))
public class ProductController {

    private final ProductService service;

    @ModelAttribute("product")
    public Product product(@PathVariable("productId") int productId) {
        return this.service.findById(productId)
                           .orElseThrow(() -> new NoSuchElementException(
                                          "catalogue.errors.product.not_found"));
    }

    @GetMapping
    public String getProduct() {
        return "catalogue/products/product";
    }

    @GetMapping("edit")
    public String getProductEdit() {
        return "catalogue/products/edit";
    }

    @PostMapping("edit")
    public String updateProduct(
            @ModelAttribute(name = "product", binding = false) Product product,
            @Valid PostProductPayload payload,
            HttpServletResponse response,
            Model model
            ) {
        try {
            this.service.updateProduct(product.getId(), payload);
            return "redirect:/catalogue/products/%d".formatted(product.getId());
        } catch (BadRequestException exception) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            model.addAttribute("payload", payload);
            model.addAttribute("errors", exception.getErrors());
            return "catalogue/products/edit";
        }
    }

    @PostMapping("delete")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        this.service.deleteProduct(product.getId());
        return "redirect:/catalogue/products/list";
    }
}
