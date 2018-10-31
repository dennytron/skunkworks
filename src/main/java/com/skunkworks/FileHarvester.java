package com.skunkworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileHarvester extends DataUtils implements Harvester {
    private String fileName;
    private List<String> words;
    private List<String> wordSets;
    private Map<String, Long> wordCounts;
    private Map<String, Long> numberWordCounts;

    FileHarvester(String fileName) {
        this.fileName = fileName;
        populateWordList();
        populateWordCounts();
        populateWordGroups();
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getWordSets() {
        return wordSets;
    }

    public Map<String, Long> getWordCounts() {
        return wordCounts;
    }

    public Map<String, Long> getNumberWordCounts() {
        return numberWordCounts;
    }

    public void populateWordList() {
        try {
            words = Files.lines(Paths.get(fileName))
                    .flatMap(line -> Pattern.compile(" ").splitAsStream(line))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateWordCounts() {
        assert words != null;

        wordCounts = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        numberWordCounts = words.stream()
                .filter(FileHarvester::isDigit)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public void populateWordGroups() {
        List<String> popper = new ArrayList<>();
        wordSets = new ArrayList<>();

        words.forEach( word -> {
            popper.add(word);
            if (popper.size() == 3) {
                wordSets.add(String.join(" ", popper));
                popper.remove(0);
            }
        });
    }
}
