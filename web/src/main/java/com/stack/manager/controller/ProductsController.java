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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {

    private final ProductClient client;

    @GetMapping(value = "list")
    public String getProductsList(
            Model model,
            @RequestParam(name = "filter", required = false) String filter,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {

        List<Product> products = this.client.findAll(filter, page * size, size);

        model.addAttribute("filter", filter);
        model.addAttribute("currentPage", page);
        model.addAttribute("products", products);
        model.addAttribute("totalPages", products.size());

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
            model.addAttribute("errors", getErrors(bindingResult));
            return "catalogue/products/add";
        } else {
            Product product = this.client.create(payload);
            return "redirect:/catalogue/products/%d".formatted(product.getId());
        }
    }

    private static List<String> getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors()
                            .stream()
                            .map(ObjectError::getDefaultMessage)
                            .toList();
    }
}
