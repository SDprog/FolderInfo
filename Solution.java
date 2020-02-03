package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Path path = Paths.get(str);
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        if (!Files.isDirectory(path)){
            System.out.println(path.toAbsolutePath() + " - не папка");
        } else
            Files.walkFileTree(Paths.get(str), searchFileVisitor);

            System.out.println("Всего папок - " + searchFileVisitor.getCountFolders());
            System.out.println("Всего файлов - " + searchFileVisitor.getCountFiles());
            System.out.println("Общий размер - " + searchFileVisitor.getCountBytes());
    }
}
