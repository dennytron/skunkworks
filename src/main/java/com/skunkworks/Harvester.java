package com.skunkworks;

import java.util.List;
import java.util.Map;

public interface Harvester {
    List<String> getWords();
    List<String> getWordSets();
    Map<String, Long> getWordCounts();
    Map<String, Long> getNumberWordCounts();
}
