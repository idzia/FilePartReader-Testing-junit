package com.codecool.java;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testReadLinesBeforeSetup() {
        FilePartReader file = new FilePartReader();
        assertThrows(NullPointerException.class, ()->{file.readLines();});
    }

    @Test
    public void testSetupFromLineLT1() {
        FilePartReader file = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {
            file.setup("src/main/resources/test_data.txt", 0, 4);
        });
    }

    @Test
    public void testSetupToLineLTFromLine() {
        FilePartReader file = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {
            file.setup("src/main/resources/test_data.txt", 4, 3);
        });
    }

    @Test
    public void testReadLines1_2() throws IOException {
        FilePartReader file = new FilePartReader();
        file.setup("src/main/resources/test_data.txt", 1, 2);
        assertEquals("1a1 2b 2a ", file.readLines());
    }

    @Test
    public void testReadLines2_4() throws IOException {
        FilePartReader file = new FilePartReader();
        assertAll("lines24", ()->{
            file.setup("src/main/resources/test_data.txt", 2, 4);
            assertEquals("2b 2a 3c 3b 3a 4d 4cr 4bb4 4a ", file.readLines());
        });
    }

    @Test
    public void testReadLinesAll() throws IOException {
        FilePartReader file = new FilePartReader();
        file.setup("src/main/resources/test_data.txt", 1, 7);
        String allLines = "1a1 2b 2a 3c 3b 3a 4d 4cr 4bb4 4a 5e 5d 5c 5b 5ax 6f 6ea 6d 6ca 6bb 6a 7g 7f 7ea ";
        assertEquals(allLines, file.readLines());
    }

    @Test
    public void testReadLinesPastEof() {
        FilePartReader file = new FilePartReader();
        file.setup("src/main/resources/test_data.txt", 4, 9);
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            file.readLines();
        });
    }

}