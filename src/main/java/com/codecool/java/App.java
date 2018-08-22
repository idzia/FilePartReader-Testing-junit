package com.codecool.java;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main (String[] args) {
        FilePartReader test = new FilePartReader();
        test.setup("src/main/resources/test_data.txt", 1, 8);
        System.out.println("wczytano ustawienia");
        try {
            test.readLines();
        } catch (FileNotFoundException e ) {
            System.out.println("failed read FileNotFound");
        } catch (IOException e) {
            System.out.println("failed IOEx");
        } catch (IndexOutOfBoundsException e ) {
            System.out.println("lineTo is to big");
        }
    }
}
