package ru.dataart.academy.java;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Integer numberOfChar = Calculator.getNumberOfChar("src/main/resources/zip.zip", '1');
            System.out.println("Calculator get number of 1 : " + numberOfChar);
            Integer maxWordLength = Calculator.getMaxWordLength("src/main/resources/zip2.zip");
            System.out.println("Calculator get max length: " + maxWordLength);
        } catch (IOException ex) {
            System.out.println("Something went wrong !");
            ex.printStackTrace();
        }
    }
}