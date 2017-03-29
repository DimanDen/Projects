/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ActionLogic.java                                         *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : В данном классе содержатся методы, определяющие действия,*
 *                 по нажатию на кнопку, не ориентируясь на определенную    *
 *                 библиотеку графического интерфейса                       *
 ****************************************************************************/
package Logic;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Дмитрий33 on 07.03.2017.
 */
public class ActionLogic {
    //Methods

    public ArrayList getListOfFiles(String selectedDirectory) {
        return DirectoryWorker.analysisDirectory(selectedDirectory); //Call method, which get list of Files in Folder
    } //End of getListOfFiles

    public void writeToFileSelectedElements(ArrayList selectedFiles, String delimiter) {
        String tempstr = "";
        Path pathToFile;
        String fileName;

        for (int i = 0; i < selectedFiles.size(); i++) {
            if (delimiter.equals("")) { //determine delimiter between files
                pathToFile = Paths.get(selectedFiles.get(i).toString());
                fileName = pathToFile.getFileName().toString();
                tempstr += "\r\n" + "\r\n" + fileName + "\r\n" + "\r\n";
            } else {
                tempstr += "\r\n" + delimiter + "\r\n";
            }

            tempstr += FileWorker.readFromFile((String) selectedFiles.get(i)); //form string of data from all selected
            //files
        }
        FileWorker.writeToFile(tempstr); //call function for write to file
    }//End of writeToFileSelectedElements
} //End of Logic.ActionLogic
