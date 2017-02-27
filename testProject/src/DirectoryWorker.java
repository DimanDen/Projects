import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
/**
 * Created by Дмитрий33 on 18.02.2017.
 */
public class DirectoryWorker {
    public static ArrayList listOfFiles = new ArrayList();

    public static void analysisDirectory(String typeOfFile) {
        JFileChooser directoryOpenDialog = new JFileChooser(); //Проблема в том, что пере
        directoryOpenDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryOpenDialog.showDialog(null, "Анализ на наличие файлов");
        File directory = directoryOpenDialog.getSelectedFile();

        System.out.println(directory);
        getFilesFromFolder(directory, typeOfFile);
    }

    public static void getFilesFromFolder(File folder, String typeOfFile)
    {
        File[] folderEntries = folder.listFiles();
        for (File item : folderEntries)
        {
            if (item.isDirectory())
            {
                getFilesFromFolder(item, typeOfFile);
                continue;
            }

            if(typeOfFile.equals("")) {
                listOfFiles.add(item);
            }
            else if(FileWorker.getFileExtension(item.getName()).equals(typeOfFile)) {
                listOfFiles.add(item);
            }
        }
    }
}
