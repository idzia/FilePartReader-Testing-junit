package com.codecool.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Mock
    private FilePartReader filePartReader;

    @BeforeEach
    public void setUp() {
        filePartReader = mock(FilePartReader.class);
    }

    @Test
    public void testWordsByABC() throws IOException {

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("abc");
        expectedList.add("def");
        expectedList.add("xyz");

        FileWordAnalyzer fileWord = new FileWordAnalyzer(filePartReader);
        when(filePartReader.readLines()).thenReturn("def xyz abc ");
        ArrayList<String> words = fileWord.wordsByABC();

        assertEquals(expectedList.get(0), words.get(0));
        assertEquals(expectedList.get(1), words.get(1));
        assertEquals(expectedList.get(2), words.get(2));
    }






    @Test
    public void testWordsByABCAscending() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        List<String> actual = fileWord.wordsByABC();
        assertEquals("1a1", actual.get(0));
        assertEquals("7g", actual.get(actual.size()-1));
    }

    @Test
    public void testWordsContainingSubStringCaseSensitive() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        ArrayList<String> wordsList = fileWord.wordsContainingSubString("BB");
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
    }


    @Test
    public void testWordsArePalindromeAllToShow() throws IOException {
        FileWordAnalyzer fileWord = new FileWordAnalyzer(new FilePartReader());
        ArrayList<String> wordsList = fileWord.wordsArePalindrome();
        assertEquals("1a1", wordsList.get(0));
        assertEquals("4bb4", wordsList.get(1));
    }




}