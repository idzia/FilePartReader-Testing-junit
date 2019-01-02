package com.codecool.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
//        filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/test_data.txt", 1, 7);
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> wordsByABC() throws IOException {
        String allLines = filePartReader.readLines();
//        String allLines = null;
        ArrayList<String> words = new ArrayList<>(Arrays.asList(allLines.split(" ")));
//        System.out.println("przed sortem");
//        for (String word : words) {
//            System.out.println(word);
//        }

        Collections.sort(words);
//        System.out.println("po sorcie");
//        for (String word : words) {
//            System.out.println(word);
//        }
        return words;
    }

    public ArrayList<String> wordsContainingSubString(String subString) throws IOException {
        String allLines = filePartReader.readLines();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(allLines.split(" ")));
        ArrayList<String> wordsWithSubString = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                wordsWithSubString.add(word);
            }
        }
//        for (String word : wordsWithSubString) {
//            System.out.println(word);
//        }
        return wordsWithSubString;
    }

    public ArrayList wordsArePalindrome() throws IOException {
        String allLines = filePartReader.readLines();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(allLines.split(" ")));
        ArrayList<String> wordsThatArePalindrome = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                wordsThatArePalindrome.add(word);
            }
        }
        for (String word : wordsThatArePalindrome) {
            System.out.println(word);
        }
        return wordsThatArePalindrome;
    }

    private boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int forward = 0;
        int backward = word.length() -1;
        while (backward > forward) {
            char forwardChar = word.charAt(forward);
            char backwardChar = word.charAt(backward);
            if (forwardChar != backwardChar ) {
                return false;
            }
            ++forward;
            --backward;
        }
        return true;
    }

}
