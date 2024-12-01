package org.example.model;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DirectoryHandler {

    public static void listFiles(String dirPath) throws IOException{
        Files.walk(Paths.get(dirPath)).forEach(System.out::println);
    }

    public static void moveFiles(Path source, Path target) throws IOException{
        Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void createDirectory(String dirPath) throws IOException {
        Path path = Paths.get(dirPath);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }
}
