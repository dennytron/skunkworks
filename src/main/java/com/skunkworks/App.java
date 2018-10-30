package com.skunkworks;

import java.util.Objects;

public class App {
    public static void main(String[] args) {
        FileHarvester fh = new FileHarvester(getTestFilePath());
        fh.fetchData();
    }

    private static String getTestFilePath() {
        return Objects.requireNonNull(App.class.getClassLoader().getResource("test_file.txt")).getFile();
    }
}
