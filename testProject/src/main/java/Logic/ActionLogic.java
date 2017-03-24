package Logic;

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

        for (int i = 0; i < selectedFiles.size(); i++) {
            if (delimiter.equals("")) { //determine delimiter between files
                tempstr += "\r\n" + "\r\n" + selectedFiles.get(i) + "\r\n" + "\r\n";
            } else {
                tempstr += "\r\n" + delimiter + "\r\n";
            }

            tempstr += FileWorker.readFromFile((String) selectedFiles.get(i)); //form string of data from all selected
            //files
        }
        FileWorker.writeToFile(tempstr); //call function for write to file
    }//End of writeToFileSelectedElements
} //End of Logic.ActionLogic
