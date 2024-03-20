package com.stack.manager.model;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public record PostProductPayload(
        String url,
        Double price,
        @NotNull(message="{errors.products.null}")
        @Size(min = 3, max = 50, message="{errors.products.size.title}")
        String title,
        @NotNull(message="{errors.products.null}")
        @Size(min = 3, max = 1000, message="{errors.products.size.details}")
        String details) {
}
