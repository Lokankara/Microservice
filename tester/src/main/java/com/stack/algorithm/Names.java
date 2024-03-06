package com.stack.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Names {

    public static int countUnpopularNames(
            String[] popularNames,
            String[] realNames) {
        int count = 0;
        for (String realName : realNames) {
            boolean isPopular = false;
            for (String popularName : popularNames) {
                if (realName.equals(popularName)) {
                    isPopular = true;
                    break;
                }
            }
            if (!isPopular) {
                count++;
            }
        }
        return count;
    }

    public String readJsonFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filename))))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line =reader.readLine())!=null)

            {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getPopularNames(String filename) {
        String json = readJsonFromFile(filename);
        int startIndex = json.indexOf("[") + 1;
        int endIndex = json.indexOf("]");
        String popularNamesString = json.substring(startIndex, endIndex);

        Scanner scanner = new Scanner(popularNamesString).useDelimiter(", ");
        List<String> popularNamesList = new ArrayList<>();
        while (scanner.hasNext()) {
            String name = scanner.next();
            name = name.substring(1, name.length() - 1);
            popularNamesList.add(name);
        }
        scanner.close();
        return popularNamesList.toArray(new String[0]);
    }

    public String[] getRealNamesByYear(
            String filename,
            int year) {
        String json = readJsonFromFile(filename);
        String yearString = "\"year\":" + year;
        int yearIndex = json.indexOf(yearString);
        if (yearIndex == -1) {
            return new String[0];
        }
        int girlsIndex = json.indexOf("\"girls\":", yearIndex);
        int start = json.indexOf("[", girlsIndex) + 1;
        int end = json.indexOf("]", start);
        String realNamesString = json.substring(start, end);
        return realNamesString.split(", ");
    }


}
