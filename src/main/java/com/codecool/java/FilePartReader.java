package com.codecool.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {

    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {

        this.filePath = filePath;

        if (fromLine < 1) throw new IllegalArgumentException("fromLine have to be bigger than 1");
        this.fromLine = fromLine;

        if (toLine < fromLine) throw new IllegalArgumentException("toLine have to be bigger than fromLine");
        this.toLine = toLine;

    }

    private String read() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        String line;
        String content = "";
        while((line = fileReader.readLine()) != null) {
            content += line +";";
            //System.out.println(content);
        }
        fileReader.close();
        return content;
    }

    public String readLines() throws IOException {
        String content = read();
        List<String> lines = Arrays.asList(content.split(";"));
        String linesToPrint = "";
        for (Integer i = fromLine-1; i < toLine; i++) {
            linesToPrint += lines.get(i) + " ";
        }

        //System.out.println(linesToPrint);
        return linesToPrint;
    }

}
