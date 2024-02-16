package com.stack.structure.array;

import com.stack.combinatoric.Cat;
import com.stack.structure.array.provider.CatArgumentsAgeLessThreeProvider;
import com.stack.structure.array.provider.CatArgumentsFeedRedAt11Provider;
import com.stack.structure.array.provider.CatArgumentsNamesProvider;
import com.stack.structure.array.provider.CatArgumentsProvider;
import com.stack.structure.array.provider.CatArgumentsProviderNamesOfEvenCats;
import com.stack.structure.array.provider.CatColorArgumentsProvider;
import com.stack.structure.array.provider.CatFeedingArgumentsProvider;
import com.stack.structure.array.provider.CatNamesProvider;
import com.stack.structure.array.provider.CatSortArgumentsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CatTest {

    private Cat cat;

    @BeforeEach
    public void setup() {
        cat = new Cat();
    }

    private static final String[] NAMES = {
            "Grey", "Tom", "Red", "Lucky",
            "Jerry", "SnowBall", "Pussy", "Tabby"};
    private static final String[] COLORS = {
            "black", "red", "white", "gray",
            "red", "gray", "black", "white"};
    private static final int[] AGES = {2, 4, 1, 3, 2, 4, 5, 1};

    @Test
    void countCatsByColor() {
        cat.countCatsByColor(COLORS);
    }

    @ParameterizedTest(name = "Test {index}: colors={0}, expected={1}")
    @ArgumentsSource(CatColorArgumentsProvider.class)
    void testGetIsCatBlack(String[] colors, boolean[] expected) {
        boolean[] actual = cat.getIsCatBlack(colors);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testGetCurrentHour() {
        int utc2Hour = LocalTime.now(ZoneId.of("UTC+02:00")).getHour();
        int result = cat.getCurrentHour();
        assertEquals(utc2Hour, result);
    }

    @ParameterizedTest(name = "{0}, sum:{1}")
    @ArgumentsSource(CatNamesProvider.class)
    void testFindBy(String[] cats, char[] letters, String[] expected) {
        String[] result = cat.findBy(cats, letters);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsProvider.class)
    void testLengthsOfArraysEqual(String[] catNames, String[] colors, int[] ages, boolean expected) {
        boolean actual = catNames.length == colors.length && colors.length == ages.length;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsProvider.class)
    void testCatInBoxNumber4(String[] catNames, String[] colors, int[] ages, boolean expected) {
        int n = 4;
        boolean actual = "Red".equals(catNames[n])
                && "red".equals(colors[n])
                && ages[n] == 3;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsProvider.class)
    void testTwoRedCatsYoungerThan3(String[] catNames, String[] colors, int[] ages, boolean expected) {
        int younger = 0;
        for (int i = 0; i < catNames.length; i++) {
            if ("red".equals(colors[i]) && ages[i] < 3) {
                younger++;
            }
        }
        boolean actual = younger == 2;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsProvider.class)
    void testCatsInBoxesWithOddIndicesNotGray(String[] catNames, String[] colors, int[] ages, boolean expected) {
        boolean actual = true;
        for (int i = 1; i < catNames.length; i += 2) {
            if ("gray".equals(colors[i])) {
                actual = false;
                break;
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    void testLengthsOfArraysEqual() {
        boolean actual = NAMES.length == COLORS.length && COLORS.length == AGES.length;
        assertTrue(actual);
    }

    @Test
    void testLengthsOfArraysNotEquals() {
        int[] AGES = {2, 4, 1, 3, 2, 4, 5};
        boolean actual = NAMES.length == COLORS.length && COLORS.length == AGES.length;
        assertFalse(actual);
    }

    @Test
    void testCatInBoxNumber4ResultFalse() {
        int n = 4;
        boolean actual = "Red".equals(NAMES[n]) && "red".equals(COLORS[n]) && AGES[n] == 3;
        assertFalse(actual);
    }

    @Test
    void testCatInBoxNumber4ResultTrue() {
        int n = 4;
        String[] NAMES = {"Grey", "Tom", "Lucky", "Jerry", "Red", "SnowBall", "Pussy", "Tabby"};
        boolean actual = "Red".equals(NAMES[n]) && "red".equals(COLORS[n]) && AGES[n] == 3;
        assertFalse(actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsNamesProvider.class)
    void testReverseCats(String[] input, String[] expected) {
        assertArrayEquals(expected, cat.reverseCats(input));
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsProviderNamesOfEvenCats.class)
    void testNamesOfEvenCats(String[] input, String[] expected) {
        assertArrayEquals(expected, cat.collectNamesOfEvenCats(input));
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsAgeLessThreeProvider.class)
    void testGetYoungCatsAgeLessThree(String[] names, int[] ages, String[] expectedCats) {
        String[] actualCats = cat.getYoungCats(names, ages);
        Arrays.stream(actualCats).forEach(Assertions::assertNotNull);
        assertArrayEquals(expectedCats, actualCats);
    }

    @ParameterizedTest
    @ArgumentsSource(CatArgumentsFeedRedAt11Provider.class)
    void testFeedCatByNameRedAt11(String[] catNames, double[] hours, boolean[][] expectedFeed) {
        boolean[][] actualFeed = cat.feedCatByNameRedAt11(catNames, hours);
        printBooleanTable(actualFeed);
        assertArrayEquals(expectedFeed, actualFeed);
    }

    @ParameterizedTest
    @ArgumentsSource(CatSortArgumentsProvider.class)
    void testSortCatsByColor(String[] colors, String[] names, String[] expectedSortedNames) {
        String[] sortedNames = cat.sortCatNamesByColor(colors, names);
        System.out.println(Arrays.toString(expectedSortedNames));
        System.out.println(Arrays.toString(colors));
        assertArrayEquals(expectedSortedNames, sortedNames);
    }

    @ParameterizedTest
    @ArgumentsSource(CatFeedingArgumentsProvider.class)
    void feedGrayCatsAt11Test(String[] names, String[] colors, double[] hours, String[] expectedMessages) {
        String[] actualMessages = cat.feedGrayCatsAt11(names, colors, hours);
        assertArrayEquals(expectedMessages, actualMessages);
    }


    @Test
    void printEvenBoxes(){
        cat.printEvenBoxes(NAMES, COLORS, AGES);
    }

    public  static void printBooleanTable(boolean[][] array) {
        for (boolean[] row : array) {
            for (boolean value : row) {
                System.out.print(value ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}
