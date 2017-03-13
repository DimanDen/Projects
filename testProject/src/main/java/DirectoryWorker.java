import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * Created by Дмитрий33 on 18.02.2017.
 */
public class DirectoryWorker {
    public static ArrayList analysisDirectory(String typeOfFile) {
        JFileChooser directoryOpenDialog = new JFileChooser(); //Проблема в том, что пере
        directoryOpenDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryOpenDialog.showDialog(null, "Анализ на наличие файлов");
        File directory = directoryOpenDialog.getSelectedFile();

        System.out.println(directory);

        return getFilesFromFolder(directory, typeOfFile);
    }

    public static ArrayList getFilesFromFolder(File folder, String typeOfFile) {
        ArrayList listOfFiles = new ArrayList();
        File[] folderEntries = folder.listFiles();

        for (File item : folderEntries) {
            if (item.isDirectory()) {
                listOfFiles.addAll(getFilesFromFolder(item, typeOfFile));
                continue;
            }

            if (typeOfFile.equals("") || FileWorker.getFileExtension(item.getName()).equals(typeOfFile)) {
                listOfFiles.add(item);
            }
        }

        return listOfFiles;
    }
}
