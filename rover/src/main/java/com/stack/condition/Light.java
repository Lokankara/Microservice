package com.stack.condition;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Light {

    private static final String[] colors = {"red", "yellow", "green", "white"};

    public static void main(String[] args) {
        Arrays.stream(colors).forEach(Light::move);
    }

    private static void move(String color) {
        switch (color) {
            case "green" -> log.info("Go");
            case "yellow" -> log.info("Steady");
            case "red" -> log.info("Stop");
            default -> log.info("Unsupported");
        }
    }
}
