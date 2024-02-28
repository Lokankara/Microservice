package com.stack.dao.repository;

import com.stack.dao.model.SqlQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class SqlParserTest {

    @Test
    void testParseQuery() {
        List<String> sqlQueries = readSqlQueriesFromFile("src/main/resources/select.sql");
        for (String sql : sqlQueries) {
            SqlQuery parser = new SqlParser().parseSql(sql);
            System.out.println(parser);
            assertNotNull(parser);
        }
    }

    public List<String> readSqlQueriesFromFile(String url) {
        Path filePath = Paths.get(url);
        List<String> sqlQueries = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(filePath));
            String[] queries = content.split(";");
            sqlQueries.addAll(Arrays.asList(queries));
            sqlQueries.remove(sqlQueries.size() - 1);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return sqlQueries;
    }

}
