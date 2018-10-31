package com.skunkworks;

import java.util.List;
import java.util.Map;

public interface DataHarvester {

    List<String> getWords();
    Map<String, Long> getWordCounts();
    Map<String, Long> getNumberWordCounts();
}
