package com.stack.inheritance;

import com.stack.geometry.Circle;
import com.stack.geometry.Rectangle;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class MaxAreasArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Stream.Builder<Arguments> arguments = Stream.builder();
        arguments.add(Arguments.of(List.of(new Circle(2.0),
                                           new Rectangle(2.0, 3.0),
                                           new Circle(3.0),
                                           new Rectangle(4.0, 5.0)), 2));
        arguments.add(Arguments.of(List.of(new Circle(2.0), new Circle(2.0)), 2));
        arguments.add(Arguments.of(List.of(new Rectangle(2.0, 3.0),
                                           new Rectangle(2.0, 3.0)), 2));
        arguments.add(Arguments.of(List.of(new Circle(2.0),
                                           new Rectangle(2.0, 3.0),
                                           new Circle(2.0),
                                           new Rectangle(2.0, 3.0)), 4));
        arguments.add(Arguments.of(List.of(new Circle(2.0),
                                           new Rectangle(2.0, 3.0),
                                           new Circle(2.0),
                                           new Rectangle(2.0, 3.0)), 4));
        arguments.add(Arguments.of(List.of(new Circle(2.0)), 1));
        arguments.add(Arguments.of(List.of(new Rectangle(2.0, 3.0)), 1));
        arguments.add(Arguments.of(List.of(new Circle(2.00),
                                           new Rectangle(2.00, 3.00),
                                           new Circle(1.00),
                                           new Rectangle(3.00, 2.00),
                                           new Circle(0.50),
                                           new Rectangle(1.00, 2.00)), 3));
        return arguments.build();
    }
}
