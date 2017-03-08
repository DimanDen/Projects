import java.util.ArrayList;

/**
 * Created by Дмитрий33 on 07.03.2017.
 */
public class ActionLogic {
    public ArrayList getListOfFiles(String selectedDirectory) {
        return DirectoryWorker.analysisDirectory(selectedDirectory);
    }

    public void writeToFileSelectedElements(ArrayList selectedFiles, String delimiter) {
        String tempstr = "";

        for(int i = 0; i < selectedFiles.size(); i ++) {
            if(delimiter.equals("")) {
                tempstr += "\r\n" + "\r\n" + selectedFiles.get(i) + "\r\n" + "\r\n";
            }
            else {
                tempstr += "\r\n" + delimiter + "\r\n";
            }

            tempstr += FileWorker.readFromFile((String)selectedFiles.get(i));
        }

        FileWorker.writeToFile(tempstr);
    }
}
