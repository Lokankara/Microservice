package com.stack.dao.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SqlQuery {

    private List<String> tokens;
    private String tableName;
    private List<String> columns;
}
