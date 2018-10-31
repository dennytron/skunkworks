package com.skunkworks;

import java.util.List;
import java.util.Map;

public interface Harvester {
    List<String> getWords();
    List<String> getWordGroups();
    Map<String, Long> getWordCounts();
    Map<String, Long> getNumberCounts();
}
