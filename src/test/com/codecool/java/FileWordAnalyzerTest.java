package com.codecool.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    public void testWordsByABCAscending() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        assertEquals("1a1", fileWord.wordsByABC().get(0));
        assertEquals("7g", fileWord.wordsByABC().get(fileWord.wordsByABC().size()-1));
    }

    @Test
    public void testWordsContainingSubStringCaseSensitive() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        ArrayList<String> wordsList = fileWord.wordsContainingSubString("BB");
        //assertEquals(2, wordsList.size());
        assertEquals("4bb4", wordsList.get(0));
        assertEquals("6bb", wordsList.get(1));
    }

    @Test
    public void testWordsContainingSubStringAllWithA() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        ArrayList<String> wordsList = fileWord.wordsContainingSubString("a");
        assertEquals(9, wordsList.size());

    }

    @Test
    public void testWordsContainingSubStringNoResult() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        ArrayList<String> wordsList = fileWord.wordsContainingSubString("2ax");
        assertNotNull(wordsList);
        //assertEquals(0, wordsList.size());
    }


    @Test
    public void testWordsArePalindromeAllToShow() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        ArrayList<String> wordsList = fileWord.wordsArePalindrome();
        assertEquals("1a1", wordsList.get(0));
        assertEquals("4bb4", wordsList.get(1));
    }




}