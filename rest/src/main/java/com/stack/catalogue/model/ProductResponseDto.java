package com.stack.catalogue.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponseDto
        implements BaseDto {

    private Integer id;
    private String url;
    private Double price;
    private String title;
    private String details;
}
