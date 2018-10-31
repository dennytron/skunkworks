package com.skunkworks;

import java.util.Objects;

public class App {

    public static void main(String[] args) {
        FileHarvester fh = new FileHarvester(getTestFilePath());

        fh.getWords().forEach(System.out::println);
        fh.getWordCounts().forEach((word, count) -> System.out.println((word + ":" + count.toString())));
        fh.getNumberWordCounts().forEach((word, count) -> System.out.println((word + ":" + count.toString())));
        fh.getWordSets().forEach(System.out::println);
    }

    private static String getTestFilePath() {
        return Objects.requireNonNull(App.class.getClassLoader().getResource("test_file.txt")).getFile();
    }
}
