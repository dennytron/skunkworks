package com.skunkworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileHarvester implements DataHarvester {

    private List<String> words;
    private Map<String, Long> wordCounts;
    private Map<String, Long> numberWordCounts;

    FileHarvester(String fileName) {
        try {
            words = Files.lines(Paths.get(fileName))
                    .flatMap(line -> Pattern.compile(" ").splitAsStream(line))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        populateWordCounts();
    }

    public List<String> getWords() {
        return words;
    }

    public Map<String, Long> getWordCounts() {
        return wordCounts;
    }

    public Map<String, Long> getNumberWordCounts() {
        return numberWordCounts;
    }

    private static boolean isDigit(String word) {
        return word.chars().allMatch(Character::isDigit);
    }

    private void populateWordCounts() {
        assert words != null;

        wordCounts = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        numberWordCounts = words.stream()
                .filter(FileHarvester::isDigit)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
