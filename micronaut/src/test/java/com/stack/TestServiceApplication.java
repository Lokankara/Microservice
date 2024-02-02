package com.image.service;

import io.micronaut.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestServiceApplication {

    @Bean
    @RestartScope
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(
                DockerImageName.parse("postgres:latest"));
    }

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }
}
