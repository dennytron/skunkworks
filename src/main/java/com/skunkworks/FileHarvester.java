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
    private List<String> wordSets;
    private Map<String, Long> wordCounts;
    private Map<String, Long> numberWordCounts;

    FileHarvester(String fileName) {
        this.fileName = fileName;
        populateWordList();

        wordCounts = populateWordCounts(words);
        wordSets = populateWordGroups(words);
        numberWordCounts = populateNumberCounts(words);
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getWordGroups() {
        return wordSets;
    }

    public Map<String, Long> getWordCounts() {
        return wordCounts;
    }

    public Map<String, Long> getNumberCounts() {
        return numberWordCounts;
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
