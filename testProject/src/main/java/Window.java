import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.*;

/**
 * Created by Дмитрий33 on 16.02.2017.
 */
public class Window extends JFrame implements ActionListener {
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

    ParticipantDialog mediator = new ParticipantDialog();

    int widthScreen; //Ширина монатора
    int heightScreen; //Высота монитора

    Window(int widthScreen, int heightScreen) {
        super("Programm for creating listing");
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        createGUI();
    }

    void createGUI() {  //метода создания графического интерфейса
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

        panel.add(new ButtonWrite(this, mediator, xStartBtnCoordinate, yStartBtnCoordinate + btnHeight + spaceBetweenBtns,
                btnWidth, btnHeight));
        panel.add(new ButtonSearch(this, mediator,xStartBtnCoordinate, yStartBtnCoordinate, btnWidth, btnHeight));
        panel.add(new ButtonSelect(this, mediator,400,260,btnWidth * 2, btnHeight));
        panel.add(new ButtonDelete(this, mediator, xStartBtnCoordinate, yStartBtnCoordinate + 2 * btnHeight + 2 * spaceBetweenBtns,
                btnWidth, btnHeight));

        panel.add(new ScrollPaneListOfFoundFiles(mediator, new ListOfFoundFiles(mediator), xStartListCoordinate, yStartListCoordinate, listWidth, listHeight));
        panel.add(new ScrollPaneListOfSelectedFiles(mediator, new ListOfSelectedFiles(mediator), xStartListCoordinate, listHeight + 100, listWidth, listHeight));

        panel.add(new TextAreaTypeOfFile(mediator,420, 580, 70, 20));

        panel.add(new LabelTypeOfFile(mediator, 280, 580, 300, 20));

        getContentPane().add(panel);

//
//        button_clearListFoundFiles = new JButton("Очистить окно найденных файлов");
//        button_clearListFoundFiles.setActionCommand("Pressed");
//        button_clearListFoundFiles.setBounds(xStartBtnCoordinate, yStartBtnCoordinate + 2 * btnHeight + 2 * spaceBetweenBtns,
//                btnWidth, btnHeight);
//        panel.add(button_clearListFoundFiles);
//
//        button_clearListChooseFiles = new JButton("Очистить окно файлов, формирующих листинг");
//        button_clearListChooseFiles.setActionCommand("Pressed");
//        button_clearListChooseFiles.setBounds(xStartBtnCoordinate, yStartBtnCoordinate + 3 * btnHeight + 3 * spaceBetweenBtns,
//                btnWidth, btnHeight);
//        panel.add(button_clearListChooseFiles);
//
//
//
//        label_Delimiter = new JLabel();
//        label_Delimiter.setBounds(270, 590, 300, 20);
//        label_Delimiter.setText("Разделительынй заголовок между файлами");
//        panel.add(label_Delimiter);
//
//        textAr_Delimiter = new JTextArea();
//        textAr_Delimiter.setBounds(570, 590, 170, 20);
//        panel.add(textAr_Delimiter);
//
//        ActionListener ss = (new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                ArrayList elements = actionLogic.getListOfFiles(textAr_typeOfFile.getText());
//
//                for (int i = 0; i < elements.size(); i++) {
//                    listModel_FoundFiles.addElement(elements.get(i).toString());
//                }
//                panel.updateUI();
//            }
//        }
//        );

//        button_clearListFoundFiles.addActionListener(new ActionListener() {
//                                                         public void actionPerformed(ActionEvent e) {
//                                                             listModel_FoundFiles.clear();
//                                                             panel.updateUI();
//                                                         }
//                                                     }
//        );
//
//        button_clearListChooseFiles.addActionListener(new ActionListener() {
//                                                          public void actionPerformed(ActionEvent e) {
//                                                              listModel_ChooseFiles.clear();
//                                                              panel.updateUI();
//                                                          }
//                                                      }
//        );
//
//        getContentPane().add(panel);
    }

    Integer setProportionalWidth(int value) {
        return widthScreen / value;
    }

    Integer setProportionalHeight(int value) {
        return heightScreen / value;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Command command = (Command) actionEvent.getSource();
        command.execute();
    }
}
