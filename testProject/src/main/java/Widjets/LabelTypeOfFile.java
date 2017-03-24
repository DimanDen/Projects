package Widjets;
import DialogDirector.DialogDirector;
import javax.swing.*;
import Command.Command;
/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class LabelTypeOfFile extends JLabel implements Command {

    DialogDirector mediator;

    public LabelTypeOfFile(DialogDirector m, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerLabelTypeOfFile(this);
        this.setText("Расширение файла");
        this.setBounds(x,y,width,height);
    }

    public void execute() {
    }
}
