package com.skunkworks;

public class App extends DataUtils {

    public static void main(String[] args) {
        FileHarvester fh = new FileHarvester(getTestFile("song.txt"));
        fh.getWords().forEach(System.out::println);
        fh.getWordCounts().forEach((word, count) -> System.out.println((word + ":" + count.toString())));
        fh.getNumberCounts().forEach((word, count) -> System.out.println((word + ":" + count.toString())));
        fh.getWordGroups().forEach(System.out::println);
        fh.getWordGroupCounts().forEach((word, count) -> System.out.println((word + ":" + count.toString())));
    }
}
