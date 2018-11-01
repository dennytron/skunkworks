package com.skunkworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestWordCollector {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNumberCounts() {
        // Expectation -- If FileHarvester reads a file with only numbers in it
        FileHarvester fh = new FileHarvester(DataUtils.getFileFromResources("words.txt"));
        Map<String, Long> expected = new HashMap<>();
        Map<String, Long> actual = fh.getNumberCounts();
        expected.put("1", 1L);
        expected.put("2", 2L);
        expected.put("3", 1L);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWordCollector() {
        // Expectation - FileHarvester reads each line of a text file and splits words on space
        //               and flattens the results into one List<String>
        FileHarvester fh = new FileHarvester(DataUtils.getFileFromResources("words.txt"));
        List<String> expected = new ArrayList<>();
        List<String> actual = fh.getWords();
        expected.add("this");
        expected.add("is");
        expected.add("a");
        expected.add("test");
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("2");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWordGroups() {
        // Expectation - WordSets collect groups of three words, start to finish, through a word list
        //               Ensure that the word set collector is populating the collection as expected
        FileHarvester fh = new FileHarvester(DataUtils.getFileFromResources("song.txt"));
        List<String> expected = new ArrayList<>();
        List<String> actual = fh.getWordGroups();
        expected.add("here i go");
        expected.add("i go again");
        expected.add("go again on");
        expected.add("again on my");
        expected.add("on my own");
        expected.add("my own on");
        expected.add("own on my");
        expected.add("on my own");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWordCounts() {
        // Expectation - Word Counts counts all words and provides counts
        //               Ensure the word set collector is populating the collection as expected
        FileHarvester fh = new FileHarvester(DataUtils.getFileFromResources("words.txt"));
        Map<String, Long> expected = new HashMap<>();
        Map<String, Long> actual = fh.getWordCounts();
        expected.put("this", 1L);
        expected.put("is", 1L);
        expected.put("a", 1L);
        expected.put("test", 1L);
        Assert.assertEquals(expected, actual);
    }
}
