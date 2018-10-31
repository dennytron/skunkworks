package com.skunkworks;

import java.util.Objects;

class TestUtils {
    static String getJustNumbersFilePath() {
        return Objects.requireNonNull(App.class.getClassLoader().getResource("just_numbers.txt")).getFile();
    }
}
