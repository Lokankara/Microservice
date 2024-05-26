package com.stack.opencart.tools;

public final class SearchStrategy {
    private static Search search;

    private SearchStrategy() {
    }

    public static Search getSearch() {
        return search;
    }
}