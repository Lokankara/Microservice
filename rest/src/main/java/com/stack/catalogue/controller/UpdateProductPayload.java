package com.stack.catalogue.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public final class UpdateProductPayload {
    @NotBlank(message = "{catalogue.products.create.errors.title_is_blank}")
    @Size(min = 3, max = 50, message = "{catalogue.products.update.errors.title_size_is_invalid}")
    @NotNull(message = "{catalogue.products.update.errors.title_is_null}")
    private final String title;
    @Size(max = 1000, message = "{catalogue.products.update.errors.details_size_is_invalid}")
    private final String details;

    public UpdateProductPayload(
            @NotNull(message = "{catalogue.products.update.errors.title_is_null}") @Size(min = 3, max = 50, message = "{catalogue.products.update.errors.title_size_is_invalid}") @NotBlank(message = "{catalogue.products.create.errors.title_is_blank}") String title,
            @Size(max = 1000, message = "{catalogue.products.update.errors.details_size_is_invalid}") String details) {
        this.title = title;
        this.details = details;
    }

    @NotBlank(message = "{catalogue.products.create.errors.title_is_blank}")
    @Size(min = 3, max = 50, message = "{catalogue.products.update.errors.title_size_is_invalid}")
    @NotNull(message = "{catalogue.products.update.errors.title_is_null}")
    public String title() {
        return title;
    }

    @Size(max = 1000, message = "{catalogue.products.update.errors.details_size_is_invalid}")
    public String details() {
        return details;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        UpdateProductPayload that = (UpdateProductPayload) obj;
        return Objects.equals(this.title, that.title) && Objects.equals(this.details,
                                                                        that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, details);
    }

    @Override
    public String toString() {
        return "UpdateProductPayload[" + "title=" + title + ", " + "details=" + details + ']';
    }
}
