package com.stack.manager.controller;

import com.stack.manager.client.ProductClient;
import com.stack.manager.model.Product;
import com.stack.manager.model.PostProductPayload;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {

    private final ProductClient client;

    @GetMapping(value = "list")
    public String getProductsList(Model model){
        model.addAttribute("products", this.client.findAll());
        return "catalogue/products/list";
    }

    @GetMapping(value = "create")
    public String getNewProductPage(){
        return "catalogue/products/add";
    }

    @PostMapping(value = "create")
    public String createNewProductPage(
            @Valid PostProductPayload payload,
            BindingResult bindingResult,
            Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("payload", payload);
            model.addAttribute("errors",
                               bindingResult.getAllErrors()
                                            .stream()
                                            .map(ObjectError::getDefaultMessage)
                                            .toList());
            return "catalogue/products/add";
        } else {
            Product product = this.client.create(payload);
            return "redirect:/catalogue/products/%d".formatted(product.getId());
        }
    }
}
