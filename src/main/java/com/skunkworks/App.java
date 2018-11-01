package com.skunkworks;

import java.io.File;
import java.util.List;
import java.util.Map;

public class App extends DataUtils {

    public static void main(String[] args) {
        readArgs(args);
        String filePath = args[0];
        String pattern = args[1].toLowerCase();

        FileHarvester fh = new FileHarvester(filePath);

        switch (pattern) {
            case "word_counts":
                fh.getWordCounts().forEach((word, count) -> System.out.println((word + ", " + count.toString())));
                break;
            case "number_counts":
                fh.getNumberCounts().forEach((word, count) -> System.out.println((word + ", " + count.toString())));
                break;
            case "group_counts":
                // keep it in order :)
                List<String> wordGroups = fh.getWordGroups();
                Map<String, Long> wordGroupCounts = fh.getWordGroupCounts();
                wordGroups.forEach(wordGroup -> System.out.println((wordGroup + ", " + (wordGroupCounts.get(wordGroup)).toString())));
                break;
        }
    }

    private static void readArgs(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar [jar] [file] [word_counts|number_counts|group_counts]");
            System.exit(1);
        } else if (!args[1].toLowerCase().equals("word_counts") &&
                !args[1].toLowerCase().equals("number_counts") &&
                !args[1].toLowerCase().equals("group_counts") ) {
            System.out.println("Bad pattern: java -jar [jar] [file] [pattern: word_counts|number_counts|group_counts]");
            System.exit(1);
        } else if (!(new File(args[0]).exists())) {
            System.out.println("Your file does not exist ");
            System.exit(1);
        }
    }
}
