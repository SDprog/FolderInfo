package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*
Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]
 */
 
public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    int countFolders = -1;
    int countFiles = 0;
    long countBytes = 0;

    public int getCountFolders() {
        return countFolders;
    }

    public int getCountFiles() {
        return countFiles;
    }

    public long getCountBytes() {
        return countBytes;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(dir)) {
            countFolders++;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(path)) {
            countFiles++;
            countBytes = countBytes + Files.size(path);
        }
        return FileVisitResult.CONTINUE;
    }
}
