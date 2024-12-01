package org.example.service;

import org.example.model.DirectoryHandler;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileMover {

    public static void moveAddonFiles(String sourceDir,String destDir, boolean backup)throws IOException {
       Path sourcePath = Paths.get(sourceDir);
       Path destPath = Paths.get(destDir);

       if (!Files.exists(sourcePath)){
           System.out.println("SOURCE FOLDER ERROR: DOESN'T EXIST");
           return;
       }
       if(backup){
           Path backupPath = destPath.resolve("addonbackup");
           if(!Files.exists(backupPath)){
              try{
                  Files.createDirectories(backupPath);
              } catch (IOException e){
                  System.out.println("Error creating backup folder");
                  return;
              }
           }
             try{
                Files.walk(destPath)
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    try{
                        Path relativePath = destPath.relativize(file);
                        Path target = backupPath.resolve(relativePath);
                        Files.copy(file,target, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Backed up -> " + target);
                    }catch (IOException e){
                        System.out.println("Error in backing up: " +e);
                    }
                });
    }catch (IOException e){
        System.out.println("error in backup process: "+e.getMessage());
    }
       }

        Files.walk(sourcePath).forEach(source -> {
            try{
                Path target = destPath.resolve(sourcePath.relativize(source));
                DirectoryHandler.moveFiles(source,target);
            }catch (IOException e){
                System.out.println("error: "+e);
            }
        });

    }
}
