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

        try (FileInputStream fin = new FileInputStream(file.getPath())) {
            System.out.println("Размер файла: " + fin.available() + " байт(а)");
            int symb = fin.read();
            while (symb != -1) {
                tempStrForData += (char) symb;
                symb = fin.read();
            }
            fin.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return tempStrForData;
    }

    static void writeToFile(String dataStr) {
        JFileChooser fileOpenDialog = new JFileChooser();
        fileOpenDialog.showDialog(null, "Записать данные в файл");
        File file = fileOpenDialog.getSelectedFile();

        try (FileOutputStream fos = new FileOutputStream(file.getPath(), true)) {
            byte[] buffer = dataStr.getBytes();
            fos.write(buffer, 0, buffer.length);
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? "" : fileName.substring(index);
    }

    static void createFile() {
        JFileChooser fileOpenDialog = new JFileChooser();
        fileOpenDialog.showDialog(null, "Создать файл");
    }

    static public String readFromFile(String directory) {
        String tempStrForData = "";

        try (FileInputStream fin = new FileInputStream(directory)) {
            System.out.println("Размер файла: " + fin.available() + " байт(а)");
            int symb = fin.read();
            while (symb != -1) {
                tempStrForData += (char) symb;
                symb = fin.read();
            }
            fin.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return tempStrForData;
    }

    static public void writeToFile(String directory, String dataStr) {
        try (FileOutputStream fos = new FileOutputStream(directory, true)) {
            byte[] buffer = dataStr.getBytes();
            fos.write(buffer, 0, buffer.length);
            fos.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
