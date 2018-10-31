package com.skunkworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWordCollector extends TestCase {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNumberCounts() {
        // Expectation -- If FileHarvester reads a file with only numbers in it
        //                numberWordCounts should contain values.
        FileHarvester fh = new FileHarvester(DataUtils.getTestFile("numbers.txt"));
        Map<String, Long> expected = new HashMap<>();
        Map<String, Long> actual = fh.getNumberCounts();
        expected.put("1", 1L);
        expected.put("2", 1L);
        expected.put("3", 1L);
        expected.put("4", 2L);
        expected.put("5", 1L);
        expected.put("6", 1L);
        expected.put("7", 1L);
        assertEquals(expected, actual);
    }

    @Test
    public void testWordCollector() {
        // Expectation - FileHarvester reads each line of a text file and splits words on space
        //               and flattens the results into one List<String>
        FileHarvester fh = new FileHarvester(DataUtils.getTestFile("words.txt"));
        List<String> expected = new ArrayList<>();
        List<String> actual = fh.getWords();
        expected.add("this");
        expected.add("is");
        expected.add("a");
        expected.add("test");
        expected.add("1");
        expected.add("2");
        expected.add("3");
        assertEquals(expected, actual);
    }

    @Test
    public void testWordSets() {
        // Expectation - WordSets collect groups of three words, start to finish, through a word list
        //               Ensure that the word set collector is populating the collection as expected
        FileHarvester fh = new FileHarvester(DataUtils.getTestFile("song.txt"));
        List<String> expected = new ArrayList<>();
        List<String> actual = fh.getWordGroups();
        expected.add("here i go");
        expected.add("i go again");
        expected.add("go again on");
        expected.add("again on my");
        expected.add("on my own");
        assertEquals(expected, actual);
    }



}
