package com.javarush;

import FileService.FileService;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        FileService fileService=new FileService();
        fileService.FileRead("C:\\Users\\matvv\\IdeaProjects\\vitalii.matviichuk.decoder\\src\\test\\test.txt");
        fileService.FileWrite();
    }
}
