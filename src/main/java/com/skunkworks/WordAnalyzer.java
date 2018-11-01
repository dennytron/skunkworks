package com.skunkworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WordAnalyzer {
    List<String> populateWordGroups(List<String> words) {
        List<String> popper = new ArrayList<>();
        List<String> wordGroups = new ArrayList<>();

        words.forEach( word -> {
            popper.add(word);
            if (popper.size() == 3) {
                wordGroups.add(String.join(" ", popper));
                popper.remove(0);
            }
        });
        return wordGroups;
    }

    Map<String, Long> populateWordCounts(List<String> words) {
        assert words != null;
        return words.stream()
                .filter(word -> !DataUtils.isDigit(word))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    Map<String, Long> populateNumberCounts(List<String> words) {
        assert words != null;
        return  words.stream()
                .filter(DataUtils::isDigit)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
