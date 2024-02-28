package com.stack.dao.repository;

import com.stack.dao.model.SqlQuery;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlParser {
    public static SqlQuery parseSQL(String input) {

        String[] lines = input.split("\\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (!line.trim().startsWith("--") && !line.trim().startsWith("#")) {
                sb.append(line);
            }
        }
        String sql = sb.toString().trim();
        Pattern pattern = Pattern.compile(
                "^SELECT\\s+(.*?)\\s+FROM\\s+(.*?)\\s+(.*)$",
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(sql.trim());

        if (matcher.matches()) {
            return new SqlQuery(Arrays.asList(sql.split("\\s+")),
                                matcher.group(2).trim(),
                                Arrays.asList(matcher.group(1).trim().split(",")));
        } else {
            throw new IllegalArgumentException("Invalid SQL query\n" + input);
        }
    }
}
