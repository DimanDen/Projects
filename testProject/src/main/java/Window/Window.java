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

    int widthWind; // Width of screen
    int heightWind; // Height of screen

    //Constructor
    public Window(int widthWind, int heightWind) {
        super("Programm for creating listing");
        this.widthWind = widthWind;
        this.heightWind = heightWind;
        createGUI();
    }// End of Constructor

    //Methods
    void createGUI() {  //Method for creating GUI

        //Method's fields
        int buttonStartCoordinateX = setProportionalWidth(0.01);
        int buttonStartCoordinateY = buttonStartCoordinateX;
        int buttonWidth = setProportionalWidth(0.25);
        int buttonHeight = setProportionalHeight(0.08);
        int spaceBetweenButtons = setProportionalWidth(0.01);

        int longButtonWidth = buttonWidth*3/2;
        int longButtonHeight = buttonHeight;
        int longButtonStartCoordinateY = setProportionalHeight(0.37);

        int listStartCoordinateX = setProportionalWidth(0.62);
        int listStartCoordinateY = setProportionalHeight(0.19);
        int listWidth = setProportionalWidth(0.68);
        int listHeight = setProportionalHeight(0.35);
        int spaceBetweenLists = setProportionalHeight(0.45);

        int labelStartCoordinateX = listStartCoordinateX-listWidth/2;
        int labelStartCoordinateY = listStartCoordinateY-listHeight/2 + spaceBetweenLists+setProportionalHeight(0.38);
        int labelWidth = setProportionalWidth(0.1);
        int labelHeight = setProportionalHeight(0.025);



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Закрытие программы по закрытию окна
        panel.setLayout(null);

        panel.add(new ButtonSearch(this, mediator,
                buttonStartCoordinateX,
                buttonStartCoordinateY,
                buttonWidth,
                buttonHeight));

        panel.add(new ButtonWrite(this, mediator,
                buttonStartCoordinateX,
                buttonStartCoordinateY + buttonHeight + spaceBetweenButtons,
                buttonWidth,
                buttonHeight));

        panel.add(new ButtonDelete(this, mediator,
                buttonStartCoordinateX,
                buttonStartCoordinateY + 2 * buttonHeight + 2 * spaceBetweenButtons,
                buttonWidth,
                buttonHeight));

        panel.add(new ButtonSelect(this, mediator,
                listStartCoordinateX-longButtonWidth/2,
                longButtonStartCoordinateY,
                longButtonWidth,
                longButtonHeight));


        panel.add(new ScrollPaneListOfFoundFiles(mediator, new ListOfFoundFiles(mediator),
                listStartCoordinateX-listWidth/2,
                listStartCoordinateY-listHeight/2,
                listWidth,
                listHeight));

        panel.add(new ScrollPaneListOfSelectedFiles(mediator, new ListOfSelectedFiles(mediator),
                listStartCoordinateX-listWidth/2,
                listStartCoordinateY-listHeight/2 + spaceBetweenLists,
                listWidth,
                listHeight));

        panel.add(new LabelTypeOfFile(mediator,
                labelStartCoordinateX,
                labelStartCoordinateY,
                labelWidth,
                labelHeight));

        panel.add(new TextAreaTypeOfFile(mediator,
                labelStartCoordinateX+labelWidth+setProportionalHeight(0.01),
                labelStartCoordinateY,
                labelWidth,
                labelHeight));



        getContentPane().add(panel);
        setBounds(0,0,widthWind,heightWind);


    }

    Integer setProportionalWidth(double value) {
        return (int)Math.floor(widthWind * value);
    }
    Integer setProportionalHeight(double value) {
        return (int)Math.floor(heightWind * value);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Command command = (Command) actionEvent.getSource();
        command.execute();
    }//End of actionPerformed
}// End of Window.Window
