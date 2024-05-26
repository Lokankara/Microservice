package com.stack.thread;

import java.util.List;

public class Editor {
    static class Counters {

        private final int words;
        private final int lines;

        public Counters() {
            this(0, 0);
        }

        public Counters(int lines, int words) {
            this.lines = lines;
            this.words = words;
        }

        public String getString() {
            return String.format("Lines: %s, Words: %s", lines, words);
        }
    }

    public static Counters wc(List<String> lines) {
        return lines.parallelStream()
                .map(line -> new Counters(1, line.split(" ").length))
                .reduce(new Counters(), (c1, c2) -> new Counters(c1.lines + c2.lines, c1.words + c2.words));
    }

    public static void main(String[] args) {
        System.out.println(wc(List.of(
                "This is my first line",
                "Second line",
                "Third line",
                "I'm really tired of typing lines",
                "sdfsda sdfopi uhsdof uyiusdf lkjew"
        )).getString());
    }
}
