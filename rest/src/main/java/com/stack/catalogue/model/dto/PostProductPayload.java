package com.stack.catalogue.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostProductPayload (
        String url,
        Double price,
        @NotNull(message = "{catalogue.products.update.errors.title_is_null}")
        @Size(min = 3, max = 50, message = "{catalogue.products.update.errors.title_size_is_invalid}")
        String title,

        @Size(max = 1000, message = "{catalogue.products.update.errors.details_size_is_invalid}")
        String details

){ }
