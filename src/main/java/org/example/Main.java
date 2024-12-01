package org.example;

import org.example.ui.FileChooserUI;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            FileChooserUI gui = new FileChooserUI();

            gui.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
        }

