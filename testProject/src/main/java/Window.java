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
    JButton button_AnalysisDirectory;
    JButton button_WriteToFile;
    JButton button_clearListFoundFiles;
    JButton button_clearListChooseFiles;
    DefaultListModel listModel_FoundFiles;
    JList listOfFoundFiles;
    JScrollPane scrollPaneFirst;
    DefaultListModel listModel_ChooseFiles;
    JList listOfChooseFiles;
    JScrollPane scrollPaneSecond;
    JButton button_addToListFoundFiles;
    JLabel label_reference;
    JTextArea textAr_typeOfFile;
    JLabel label_Delimiter;
    JTextArea textAr_Delimiter;
    ActionLogic actionLogic;


    int widthScreen; //Ширина монатора
    int heightScreen; //Высота монитора

    Window (int widthScreen, int heightScreen) {
        super("Programm for creating listing");
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        createGUI();
    }
    void createGUI () {  //метода создания графического интерфейса
        int xStartBtnCoordinate = setProportionalWidth(100); //widthScreen/100;
        int yStartBtnCoordinate = xStartBtnCoordinate;
        int btnWidth = setProportionalWidth(8);
        int btnHeight = setProportionalHeight(21);
        int spaceBetweenBtns = setProportionalWidth(192);

        int xStartListCoordinate = 270; //widthScreen/100;
        int yStartListCoordinate = 10;
        int listWidth = 800;
        int listHeight = 230;
        int spaceBetweenLists = 80;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Закрытие программы по закрытию окна
        panel.setLayout(null);

        button_AnalysisDirectory = new JButton("Поиск файлов");
        button_AnalysisDirectory.setActionCommand("Pressed");
        button_AnalysisDirectory.setBounds(xStartBtnCoordinate,yStartBtnCoordinate,btnWidth,btnHeight);
        panel.add(button_AnalysisDirectory);

        button_WriteToFile = new JButton("Записать выбранные файлы");
        button_WriteToFile.setActionCommand("Pressed");
        button_WriteToFile.setBounds(xStartBtnCoordinate,yStartBtnCoordinate + btnHeight + spaceBetweenBtns,
                btnWidth,btnHeight);
        panel.add(button_WriteToFile);

        button_clearListFoundFiles = new JButton("Очистить окно найденных файлов");
        button_clearListFoundFiles.setActionCommand("Pressed");
        button_clearListFoundFiles.setBounds(xStartBtnCoordinate,yStartBtnCoordinate + 2*btnHeight + 2*spaceBetweenBtns,
                btnWidth,btnHeight);
        panel.add(button_clearListFoundFiles);

        button_clearListChooseFiles = new JButton("Очистить окно файлов, формирующих листинг");
        button_clearListChooseFiles.setActionCommand("Pressed");
        button_clearListChooseFiles.setBounds(xStartBtnCoordinate,yStartBtnCoordinate + 3*btnHeight + 3*spaceBetweenBtns,
                btnWidth,btnHeight);
        panel.add(button_clearListChooseFiles);

        listModel_FoundFiles = new DefaultListModel(); //Создание модели списка
        listOfFoundFiles = new JList(listModel_FoundFiles); //В качестве параметра модержимого в список передаем ссылку на модель
        listOfFoundFiles.setLayoutOrientation(JList.VERTICAL);

        scrollPaneFirst = new JScrollPane(listOfFoundFiles);
        scrollPaneFirst.setBounds(xStartListCoordinate,yStartListCoordinate,listWidth,listHeight);
        panel.add(scrollPaneFirst);

        listModel_ChooseFiles = new DefaultListModel(); //Создание модели списка
        listOfChooseFiles = new JList(listModel_ChooseFiles); //В качестве параметра модержимого в список передаем ссылку на модель
        listOfChooseFiles.setLayoutOrientation(JList.VERTICAL);

        scrollPaneSecond = new JScrollPane(listOfChooseFiles);
        scrollPaneSecond.setBounds(
                scrollPaneFirst.getX(),
                scrollPaneFirst.getHeight()+spaceBetweenLists,
                listWidth,
                listHeight);
        panel.add(scrollPaneSecond);

        button_addToListFoundFiles = new JButton("Добавить в список файлов, формирующих листинг");
        button_addToListFoundFiles.setActionCommand("Pressed");
        button_addToListFoundFiles.setBounds(
                scrollPaneFirst.getX() + scrollPaneFirst.getWidth()/2 - btnWidth,
                scrollPaneFirst.getY() + scrollPaneFirst.getHeight() + spaceBetweenLists/8,
                btnWidth*2,
                btnHeight);
        panel.add(button_addToListFoundFiles);


        label_reference = new JLabel();
        label_reference.setBounds(270,550,150,20);
        label_reference.setText("Расширение файла");
        panel.add(label_reference);

        textAr_typeOfFile = new JTextArea();
        textAr_typeOfFile.setBounds(420,550,70,20);
        panel.add(textAr_typeOfFile);

//        public void getTextAr_typeOfFile(int listWidth) {
//            this.textAr_typeOfFile = textAr_typeOfFile;
//        }


        label_Delimiter = new JLabel();
        label_Delimiter.setBounds(270,590,300,20);
        label_Delimiter.setText("Разделительынй заголовок между файлами");
        panel.add(label_Delimiter);

        textAr_Delimiter = new JTextArea();
        textAr_Delimiter.setBounds(570,590,170,20);
        panel.add(textAr_Delimiter);

        actionLogic = new ActionLogic();

        button_AnalysisDirectory.addActionListener(new ActionListener() {
                                                       public void actionPerformed(ActionEvent e) {
                                                           ArrayList elements = actionLogic.getListOfFiles(textAr_typeOfFile.getText());

                                                           for(int i = 0; i < elements.size(); i ++)
                                                           {
                                                               listModel_FoundFiles.addElement(elements.get(i).toString());
                                                           }
                                                           panel.updateUI();
                                                       }
                                                   }
        );

        button_WriteToFile.addActionListener(new ActionListener() {
                                                       public void actionPerformed(ActionEvent e) {
                                                           ArrayList selectedFiles = new ArrayList();

                                                           for (int i = 0; i < listModel_ChooseFiles.size(); i++) {
                                                               selectedFiles.add(listModel_ChooseFiles.get(i));
                                                           }

                                                           actionLogic.writeToFileSelectedElements(selectedFiles
                                                                   , textAr_Delimiter.getText());
                                                           JOptionPane.showMessageDialog(null, "Успешно записано!");
                                                           panel.updateUI();
                                                       }
                                                   }
        );

        button_clearListFoundFiles.addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent e) {
                                                        listModel_FoundFiles.clear();
                                                        panel.updateUI();
                                                    }
                                                }
        );

        button_clearListChooseFiles.addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent e) {
                                                        listModel_ChooseFiles.clear();
                                                        panel.updateUI();
                                                    }
                                                }
        );

        button_addToListFoundFiles.addActionListener(new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             int[] arrayOfChoosen = listOfFoundFiles.getSelectedIndices();
                                                             for (int i = 0; i < arrayOfChoosen.length; i ++) {
                                                                 listModel_ChooseFiles.addElement(listModel_FoundFiles.get(arrayOfChoosen[i]));
                                                             }
                                                             panel.updateUI();
                                                         }
                                                     }
        );

        getContentPane().add(panel);
    }

    Integer setProportionalWidth(int value) {
        return widthScreen/value;
    }

    Integer setProportionalHeight(int value) {
        return heightScreen/value;
    }
}
