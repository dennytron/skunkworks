package com.skunkworks;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestWordCollector extends TestUtils {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadSomeData() {
        // Expectation -- If FileHarvester reads a file with only numbers in it
        //                numberWordCounts should contain values.
        FileHarvester fh = new FileHarvester(getJustNumbersFilePath());
        Map<String, Long> expected = new HashMap<>();
        Map<String, Long> actual = fh.getNumberWordCounts();
        expected.put("1", 1L);
        expected.put("2", 1L);
        expected.put("3", 1L);
        expected.put("4", 2L);
        expected.put("5", 1L);
        expected.put("6", 1L);
        expected.put("7", 1L);
        assertEquals(expected, actual);
    }

}
