package com.skunkworks;

import java.util.Objects;

class DataUtils {
    static boolean isDigit(String word) {
        return word.chars().allMatch(Character::isDigit);
    }

    static String getTestFile(String fileName) {
        return Objects.requireNonNull(App.class.getClassLoader().getResource(fileName)).getFile();
    }
}
