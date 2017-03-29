/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : DialogDirector.java                                      *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Класс, содержащий методы для работы с директорией        *
 *                                                                          *
 *                                                                          *
 ****************************************************************************/

package Logic;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * Created by Дмитрий33 on 18.02.2017.
 */
public class DirectoryWorker {

    //Methods
    public static ArrayList analysisDirectory(String typeOfFile) {
        JFileChooser directoryOpenDialog = new JFileChooser(); //Create dialog
        directoryOpenDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Set dialog for choosing catalog
        directoryOpenDialog.showDialog(null, "Анализ на наличие файлов"); //Open dialog
        File directory = directoryOpenDialog.getSelectedFile();

        System.out.println(directory);

        return getFilesFromFolder(directory, typeOfFile); //Call function for recursive search
    } //End of analysisDirectory

    public static ArrayList getFilesFromFolder(File folder, String typeOfFile) {
        ArrayList listOfFiles = new ArrayList();
        File[] folderEntries = folder.listFiles();

        for (File item : folderEntries) { //Cycle through all the files and in the folder
            if (item.isDirectory()) {
                listOfFiles.addAll(getFilesFromFolder(item, typeOfFile)); //Call this method again, because was meeting
                //the folder
                continue;
            }

            if (typeOfFile.equals("") || FileWorker.getFileExtension(item.getName()).equals(typeOfFile)) {
                listOfFiles.add(item); //If was meeting file and its extension equals extension in textBox or "" then
                //push them in array
            }
        }
        return listOfFiles;
    } //End of analysisDirectory
} //End of DirectoryWorker







