package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatSortArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(new String[]{"Grey", "Black", "White"},
                                      new String[]{"Tom", "Luna", "Simba"},
                                      new String[]{"Luna", "Tom", "Simba"}),
                         Arguments.of(new String[]{"Black", "White", "White", "Red", "Gray", "Gray", "Black", "White"},
                                      new String[]{"Spot", "Stripe", "Paws", "Claws", "Whiskers", "Simba", "Scaredy", "Sneaky"},
                                      new String[]{"Spot", "Scaredy", "Whiskers", "Simba", "Claws", "Stripe", "Paws", "Sneaky"}),
                         Arguments.of(new String[]{"Rose", "Bubblegum", "Blush", "Fuchsia", "Carnation", "Magenta", "Salmon", "Peony"},
                                      new String[]{"Spot", "Stripe", "Paws", "Claws", "Whiskers", "Simba", "Scaredy", "Sneaky"},
                                      new String[]{"Paws", "Stripe", "Whiskers", "Claws", "Simba", "Sneaky", "Spot", "Scaredy"}),
                         Arguments.of(new String[]{"Azure", "Cerulean", "Cobalt", "Indigo", "Navy", "Sapphire",  "Teal"},
                                      new String[]{"Grasshopper", "Olive", "Leaf", "Emerald", "Shamrock", "Mint", "Jade"},
                                      new String[]{"Grasshopper", "Olive", "Leaf", "Emerald", "Shamrock", "Mint", "Jade"}),
                         Arguments.of(new String[]{"Yellow", "Blue", "Blue", "Yellow", "Blue", "Yellow", "Yellow", "Blue"},
                                      new String[]{"Sunshine", "Sky", "Ocean", "Dandelion", "Wave", "Buttercup", "Sapphire", "Puddle"},
                                      new String[]{"Sky", "Ocean", "Wave", "Puddle", "Sunshine", "Dandelion", "Buttercup", "Sapphire"}),
                         Arguments.of(new String[]{"Buttercup", "Puddle", "Sapphire", "Ocean", "Sky"},
                                      new String[]{"Snowball", "Cotton", "Angel", "Cloud", "Ivory"},
                                      new String[]{"Snowball", "Cloud", "Cotton", "Angel",  "Ivory"}),
                         Arguments.of(new String[]{"Black", "Black", "Black", "Black", "Black", "Black"},
                                      new String[]{"Midnight", "Coal", "Raven", "Shadow", "Onyx", "Jet"},
                                      new String[]{"Midnight", "Coal", "Raven", "Shadow", "Onyx", "Jet"}),
                         Arguments.of(new String[]{"Coal", "Jet", "Midnight", "Onyx", "Raven", "Shadow", "Onyx", "Shadow"},
                                      new String[]{"Ruby", "Cherry", "Scarlet", "Crimson", "Brick", "Rose", "Carmine", "Garnet"},
                                      new String[]{"Ruby", "Cherry", "Scarlet", "Crimson", "Carmine", "Brick", "Rose", "Garnet"}));
    }
}
