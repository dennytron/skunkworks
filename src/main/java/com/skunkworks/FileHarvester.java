package com.skunkworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileHarvester implements DataHarvester {

    private String fileName;

    FileHarvester(String fileName) {
        this.fileName = fileName;
    }

    public List<String> fetchData() {
        List<String> words = new ArrayList<>();

        try {
            words =  Files.lines(Paths.get(fileName))
                    .flatMap(line -> Pattern.compile(" ").splitAsStream(line))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
}
