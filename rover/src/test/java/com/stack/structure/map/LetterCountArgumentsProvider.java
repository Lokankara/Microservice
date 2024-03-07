package com.stack.structure.map;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LetterCountArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {
        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('h', 1);
        map1.put('e', 1);
        map1.put('l', 3);
        map1.put('o', 2);
        map1.put('w', 1);
        map1.put('r', 1);
        map1.put('d', 1);
        map1.put(' ', 1);

        Map<Character, Integer> map2 = new HashMap<>();
        map2.put('t', 2);
        map2.put('e', 1);
        map2.put('s', 1);

        return Stream.of(Arguments.of("Hello World", map1),
                         Arguments.of("test", map2),
                         Arguments.of("", new HashMap<>()),
                         Arguments.of(null, new HashMap<>()));
    }
}
