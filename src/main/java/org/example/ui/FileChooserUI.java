package org.example.ui;

import org.example.service.FileMover;

import javax.swing.*;
import java.io.IOException;

public class FileChooserUI {
    public void start() throws IOException{

        //source
        JFileChooser sourceChooser = new JFileChooser();
        sourceChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int sourceResult = sourceChooser.showOpenDialog(null);
        if(sourceResult != JFileChooser.APPROVE_OPTION){
            return;
        }
        String sourceDir = sourceChooser.getSelectedFile().getAbsolutePath();

        //destination
        JFileChooser destChooser = new JFileChooser();
        destChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int destResult = destChooser.showOpenDialog(null);
        if(destResult != JFileChooser.APPROVE_OPTION){
            return;
        }
        String destDir = destChooser.getSelectedFile().getAbsolutePath();
        int backupChoice = JOptionPane.showConfirmDialog(null,"Do you want to backup your addons?","backup", JOptionPane.YES_NO_OPTION);
        boolean backup = backupChoice == JOptionPane.YES_OPTION;

        FileMover.moveAddonFiles(sourceDir,destDir,backup);
    }
}
