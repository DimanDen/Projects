package Window;

import Command.Command;
import DialogDirector.ParticipantDialog;
import Widjets.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Дмитрий33 on 16.02.2017.
 */
public class Window extends JFrame implements ActionListener {
    //Fields
    JPanel panel = new JPanel(); //Creating container of panel
    ParticipantDialog mediator = new ParticipantDialog(); //Creating participant of Mediator

    int widthScreen; // Width of screen
    int heightScreen; // Height of screen

    //Constructor
    public Window(int widthScreen, int heightScreen) {
        super("Programm for creating listing");
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        createGUI();
    }// End of Constructor

    //Methods
    void createGUI() {  //Method for creating GUI

        //Method's fields
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
    }//End of actionPerformed
}// End of Window.Window
