import java.io.*;
import javax.swing.JFileChooser;

/**
 * Created by Дмитрий33 on 16.02.2017.
 */
public class FileWorker {
    static public String readFromFile() {
        String tempStrForData = "";
        JFileChooser fileOpenDialog = new JFileChooser();
        fileOpenDialog.showDialog(null, "Cчитать данные из файла");
        File file = fileOpenDialog.getSelectedFile();

        return readFromFile(file.getPath());
    }

    static void writeToFile(String dataStr) {
        JFileChooser fileOpenDialog = new JFileChooser();
        fileOpenDialog.showDialog(null, "Записать данные в файл");
        File file = fileOpenDialog.getSelectedFile();
        writeToFile(file.getPath(), dataStr);
    }

    static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? "" : fileName.substring(index);
    }

    static String readFromFile(String directory) {
        String tempStrForData = "";
        try (FileInputStream fin = new FileInputStream(directory)) {
            Reader reader = new InputStreamReader(fin, "UTF-8");
            System.out.println("Размер файла: " + fin.available() + " байт(а)");
            int symb = reader.read();
            while (symb != -1) {
                tempStrForData += (char) symb;
                symb = reader.read();
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return tempStrForData;
    }

    static void writeToFile(String directory, String dataStr) {
        try (FileOutputStream fos = new FileOutputStream(directory, true)) {
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            writer.write(dataStr);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
