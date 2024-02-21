package com.stack.model.provider;

import com.stack.model.gym.Jock;
import com.stack.model.gym.Role;
import com.stack.model.gym.Sled;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class GymArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        Sled ten = new Sled(10);
        Sled fifty = new Sled(50);
        Sled twenty = new Sled(20);

        Sled[] amoeba = {ten};
        Sled[] beefcake = {ten, ten, ten};
        Sled[] beefcake2 = {ten, new Sled(11), ten};
        Sled[] beefcake3 = {ten, new Sled(29), ten};
        Sled[] android = {ten, twenty, twenty};
        Sled[] android2 = {new Sled(15), twenty, twenty};
        Sled[] android3 = {new Sled(33), new Sled(33), new Sled(33)};
        Sled[] terminator = {twenty, new Sled(30), fifty};
        Sled[] terminator2 = {twenty, fifty, fifty};

        return Stream.of(
                Arguments.of(new Jock("Alice", amoeba), Role.AMOEBA),
                Arguments.of(new Jock("Bob", beefcake), Role.BEEFCAKE),
                Arguments.of(new Jock("Charlie", beefcake2), Role.BEEFCAKE),
                Arguments.of(new Jock("David", beefcake3), Role.BEEFCAKE),
                Arguments.of(new Jock("Eve", android), Role.ANDROID),
                Arguments.of(new Jock("Frank", android2), Role.ANDROID),
                Arguments.of(new Jock("George", android3), Role.ANDROID),
                Arguments.of(new Jock("Hank", terminator), Role.TERMINATOR),
                Arguments.of(new Jock("Jack", terminator2), Role.TERMINATOR)
        );
    }
}
