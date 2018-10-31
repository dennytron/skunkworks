package com.skunkworks;

class DataUtils {

    static boolean isDigit(String word) {
        return word.chars().allMatch(Character::isDigit);
    }
}
