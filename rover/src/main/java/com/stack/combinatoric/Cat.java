package com.stack.combinatoric;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class Cat {

    public String[] findBy(
            String[] cats,
            char[] letters) {
        List<String> result = new ArrayList<>();
        for (String cat : cats) {
            for (char letter : letters) {
                if ((cat.charAt(0) ^ letter) == 0 && cat.startsWith(String.valueOf(
                        letter))) {
                    result.add(cat);
                    break;
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public int getCurrentHour() {
        return LocalTime.now().getHour();
    }

    public String feed(
            String name,
            String color) {
        return isRed(color)
               ? "Fed the cat " + name
               : "The cat is not red";
    }

    public boolean isRed(String color) {
        return "red".equals(color);
    }

    public String[] getYoungCats(
            String[] names,
            int[] ages) {
        if (names == null) {
            return new String[0];
        }
        int size = names.length;
        int count = 0;
        boolean[] younger = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (ages[i] < 3) {
                younger[i] = true;
                count++;
            }
        }
        String[] cats = new String[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (younger[i]) {
                cats[j] = names[i];
                j++;
            }
        }
        return cats;
    }

    public int countCatsByColor(
            String[] colors,
            String color) {
        int count = 0;
        for (String c : colors) {
            if (color.equals(c)) {
                log.info("There are " + count + " " + color + " cats.");
                count++;
            }
        }
        return count;
    }

    public boolean[][] feedCatByNameRedAt11(
            String[] catNames,
            double[] hours) {
        int catSize = catNames.length;
        int hourSize = hours.length;
        boolean[][] feed = new boolean[catSize][hourSize];

        for (int j = 0; j < hourSize; j++) {
            if (hours[j] == 11.0) {
                for (int i = 0; i < catSize; i++) {
                    if ("Red".equalsIgnoreCase(catNames[i])) {
                        feed[i][j] = true;
                    }
                }
            }
        }

        return feed;
    }

    public String[] sortCatNamesByColor(
            String[] colors,
            String[] names) {
        if (colors == null || names == null || colors.length != names.length) {
            throw new IllegalArgumentException("Input arrays must not be null and must have the same length.");
        }

        Integer[] indices = new Integer[colors.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparing(i -> colors[i]));

        String[] sortedNames = new String[names.length];
        for (int i = 0; i < sortedNames.length; i++) {
            sortedNames[i] = names[indices[i]];
        }

        return sortedNames;
    }

    public String combineNamesOfEvenCats(String[] names) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i += 2) {
            sb.append(names[i]).append(" ");
        }
        return sb.toString().trim();
    }


    public void printEvenBoxes(
            String[] names,
            String[] colors,
            int[] ages) {
        for (int i = 0; i < names.length; i += 2) {
            log.info("The Box#{}: name: {}, color:{}, age:{}",
                     i, names[i], colors[i], ages[i]);
        }
    }

    public String[] feedGrayCatsAt11(
            String[] names,
            String[] colors,
            double[] hours) {
        String[] messages = new String[hours.length];
        for (int i = 0; i < hours.length; i++) {
            messages[i] = "Something went wrong...";
            if (hours[i] == 11.0) {
                for (int j = 0; j < colors.length; j++) {
                    if ("gray".equals(colors[j])) {
                        messages[i] = "Cat %s fed at 11am".formatted(names[j]);
                    }
                }
            }
        }
        return messages;
    }

    public void printYoungerThanFour(String[] names, int[] ages) {
        for (int i = 0; i < ages.length; i++) {
            if (ages.length < 4){
                log.info("The Box#{}: name: {}, age:{}",
                         i, names[i], ages[i]);
            }
        }
    }

    public boolean[] getIsCatBlack(String[] colors) {
        boolean[] isBlack = new boolean[colors.length];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equalsIgnoreCase("black")){
                isBlack[i] = true;
            }
        }
        return isBlack;
    }

    public void countCatsByColor(String[] colors) {
        Arrays.sort(colors);
        int count = 1;
        for (int i = 1; i < colors.length; i++) {
            if (!colors[i].equals(colors[i - 1])) {
                log.info("Color: " + colors[i - 1] + ", Count: " + count);
                count = 1;
            } else {
                count++;
            }
        }
        log.info("Color: " + colors[colors.length - 1] + ", Count: " + count);
    }

    public String[] reverseCats(String[] names) {
        if (names != null) {
            int size = names.length;
            String[] reverseCats = new String[size];
            for (int i = 0; i < size; i++) {
                reverseCats[size - i - 1] = names[i];
            }
            return reverseCats;
        }
        return new String[0];
    }

    public String[] collectNamesOfEvenCats(String[] names) {
        if (names == null || names.length == 0) {
            return new String[0];
        }

        int even = names.length / 2 + (names.length % 2 == 0 ? 0 : 1);
        String[] evenCats = new String[even];
        for (int i = 0; i < even; i++) {
            evenCats[i] = names[i * 2];
        }
        return evenCats;
    }
}
