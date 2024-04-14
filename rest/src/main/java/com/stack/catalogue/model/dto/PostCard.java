package com.stack.catalogue.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostCard
        implements BaseDto {

    private Integer id;
    private String name;
    private String url;
    private String description;
}
