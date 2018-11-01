Build Instructions:

`maven package`

though, a fatjar file is included in the `bin/` directory

Run Tests:

`maven test`

Usage:

`Usage: java -jar [jar] [file] [word_counts|number_counts|group_counts]`

Example:

`java -jar PatternCounter-1.0-SNAPSHOT.jar words.txt group_counts`

Goal:

Write an extensible and reusable application that enables a user to provide 
a list of words in a file and receive a print-out of word counts and patterns.

Example files are provided in the `src/main/resources` directory.

Assumptions:

- The output showing counts of each unique number will exclude words: 
i.e. ["1", "2", "3"] and not ["1", "2", "3", "hello"]
- The output showing counts of each unique word will exclude numbers:
i.e. ["hello"] and not ["1", "2", "3", "hello"]
- I refer to a phrase of three consecutive words as a "Word Group"

Source Overview:

*App.java*

Application Entry Point

*Harvester*

Interface that describes the methods required for creating a word reader. The included word 
reader (FileHarvester) reads a text file, but other word readers could be a REST API or a Database.

*FileHarvester*

Class that provides IO functionality for reading words from a file into a List.

*WordAnalyzer*

Generic, reusable class that enables a developer to collect, analyze, and count a words in a List.

*DataUtils.java*

Generic, reusable Utilities for accessing and analyzing data