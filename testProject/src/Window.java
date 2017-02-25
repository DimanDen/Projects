import javafx.scene.layout.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Дмитрий33 on 16.02.2017.
 */
public class Window extends JFrame{
    JPanel panel = new JPanel(); //Создание контейнера панели
    int widthScreen; //Ширина монатора
    int heightScreen; //Высота монитора

    public  Window (int widthScreen, int heightScreen) {
        super("Programm for creating listing");
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        createGUI();
    }
    public void createGUI () {  //метода создания графического интерфейса
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Закрытие программы по закрытию окна
        panel.setLayout(null);

        JButton button_AnalyzisDirectory = new JButton("Проанализировать директорию");
        button_AnalyzisDirectory.setActionCommand("Pressed");
        button_AnalyzisDirectory.setBounds(0,40,200,50);
        panel.add(button_AnalyzisDirectory);

        JButton button_WriteToFile = new JButton("Записать выбранные файлы в другой файл");
        button_WriteToFile.setActionCommand("Pressed");
        button_WriteToFile.setBounds(0,450,200,50);
        panel.add(button_WriteToFile);

        DefaultListModel listModel = new DefaultListModel(); //Создание модели списка
        JList list = new JList(listModel); //В качестве параметра модержимого в список передаем ссылку на модель
        list.setLayoutOrientation(JList.VERTICAL);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(250,0,800,500);
        panel.add(scrollPane);

        JTextArea textAr_typeOfFile = new JTextArea();
        textAr_typeOfFile.setBounds(10,200,70,20);
        panel.add(textAr_typeOfFile);

        button_AnalyzisDirectory.addActionListener(new ActionListener() {
                                                       public void actionPerformed(ActionEvent e) {
                                                           DirectoryWorker.analysisDirectory(textAr_typeOfFile.getText());
                                                           ArrayList elements = DirectoryWorker.listOfFiles;
                                                           for(int i = 0; i < elements.size(); i ++)
                                                           {
                                                               listModel.addElement(elements.get(i).toString());
                                                           }
                                                           panel.updateUI();
                                                       }
                                                   }
        );

        button_WriteToFile.addActionListener(new ActionListener() {
                                                       public void actionPerformed(ActionEvent e) {
                                                           int[] arrayOfChoosen = list.getSelectedIndices();
                                                           String tempstr = "";
                                                           for(int i = 0; i < arrayOfChoosen.length; i ++)
                                                           {
                                                               tempstr += FileWorker.readFromFile((String)listModel.get(arrayOfChoosen[i]));
                                                           }
                                                           FileWorker.writeToFile(tempstr);
                                                           JOptionPane.showMessageDialog(null, "Успешно!");
                                                           panel.updateUI();
                                                       }
                                                   }
        );

        getContentPane().add(panel);
    }
}
