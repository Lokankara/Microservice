package com.stack.image.service.model;

import com.stack.image.service.validation.ConsistentSearch;
import io.micronaut.core.annotation.Introspected;
import lombok.Getter;

@Getter
@Introspected
@ConsistentSearch
public class ImageFilter
        extends PageFilter {
    private String name;
    private String path;
    private Integer height;
    private Integer width;
    private String alternativeText;

}
