package com.skunkworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileHarvester extends WordAnalyzer implements Harvester {
    private String fileName;
    private List<String> words;
    private List<String> wordGroups;
    private Map<String, Long> wordCounts;
    private Map<String, Long> numberCounts;
    private Map<String, Long> wordGroupCounts;

    FileHarvester(String fileName) {
        this.fileName = fileName;
        populateWordList();
        wordCounts = populateWordCounts(words);
        wordGroups = populateWordGroups(words);
        numberCounts = populateNumberCounts(words);
        wordGroupCounts = populateWordCounts(wordGroups);
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getWordGroups() {
        return wordGroups;
    }

    public Map<String, Long> getWordCounts() {
        return wordCounts;
    }

    public Map<String, Long> getNumberCounts() {
        return numberCounts;
    }

    public Map<String, Long> getWordGroupCounts() {
        return wordGroupCounts;
    }

    private void populateWordList() {
        try {
            words = Files.lines(Paths.get(fileName))
                    .flatMap(line -> Pattern.compile(" ").splitAsStream(line))
                    .map(String::trim)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
