package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void moveFiles(String sourceDir, String destDir) throws IOException{
        Files.createDirectories(Paths.get(destDir));
        File sourceFolder = new File(sourceDir);
        for (File file : sourceFolder.listFiles()){
            Path sourcePath = file.toPath();
            Path destPath = Paths.get(destDir,file.getName());
            Files.copy(sourcePath,destPath, StandardCopyOption.REPLACE_EXISTING);
        }

    }
    public static void main(String[] args) {
    try{
        moveFiles("D:/source","D:/dest");
    } catch(IOException e){
        e.printStackTrace();
    }
    }
}