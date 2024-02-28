package com.stack.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Serializable {
    @JsonProperty("albumId")
    private Integer albumId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("artistId")
    private Integer artistId;
}
