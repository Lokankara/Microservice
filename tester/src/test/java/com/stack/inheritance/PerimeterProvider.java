package com.stack.inheritance;

import com.stack.geometry.Rectangle;
import com.stack.geometry.Square;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class PerimeterProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(List.of(new Square(2.0),
                                              new Rectangle(2.0, 3.0)), 18.0),
                         Arguments.of(List.of(new Square(5.0),
                                              new Rectangle(2.0, 3.0),
                                              new Square(3.0)), 42.0),
                         Arguments.of(List.of(new Square(1.0),
                                              new Rectangle(1.0, 1.0)), 8.0));
    }
}
