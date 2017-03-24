package Logic;

import java.io.*;
import javax.swing.JFileChooser;

/**
 * Created by Дмитрий33 on 16.02.2017.
 */
public class FileWorker {

    //Methods
    static public String readFromFile() { //Read from file with dialog
        String tempStrForData = "";
        JFileChooser fileOpenDialog = new JFileChooser(); //Create dialog
        fileOpenDialog.showDialog(null, "Cчитать данные из файла"); //Open dialog with title
        File file = fileOpenDialog.getSelectedFile();

        return readFromFile(file.getPath()); //Call function, which read from file without dialog
    }// End of method readFromFile

    static void writeToFile(String dataStr) { //Write to file with dialog
        JFileChooser fileOpenDialog = new JFileChooser();
        fileOpenDialog.showDialog(null, "Записать данные в файл");
        File file = fileOpenDialog.getSelectedFile();
        writeToFile(file.getPath(), dataStr); //Call function, which write to file without dialog
    }// End of method writeToFile

    static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? "" : fileName.substring(index);
    }// End of method getFileExtension

    static String readFromFile(String directory) { //Read from file without dialog
        String tempStrForData = "";
        try (FileInputStream fin = new FileInputStream(directory)) {
            Reader reader = new InputStreamReader(fin, "UTF-8"); //Create thread for read
            System.out.println("Размер файла: " + fin.available() + " байт(а)");
            int symb = reader.read();
            while (symb != -1) {
                tempStrForData += (char) symb; //form string with data from file
                symb = reader.read();
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return tempStrForData;
    }// End of method readFromFile

    static void writeToFile(String directory, String dataStr) { //Write to file without dialog
        try (FileOutputStream fos = new FileOutputStream(directory, true)) {
            Writer writer = new OutputStreamWriter(fos, "UTF-8"); //Create thread for write
            writer.write(dataStr);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }// End of method readFromFile
} //End of FileWorker
