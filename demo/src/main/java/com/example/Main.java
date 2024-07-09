package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println( readFile("test.txt"));
        String content = "This is a new line\n";
        String text = "1";
        if(text=="1"){
            System.out.println("true");
            writeToFile("test.txt", content);
            System.out.println(readFile("test.txt"));
        }
        System.out.println("End of program");

    }
    //Creat a funtion to Read and a funtion to write to txt file
    public static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static String readFile(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader reader = null;
        try  {
            reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine())!= null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        
        return contentBuilder.toString();
    }

}