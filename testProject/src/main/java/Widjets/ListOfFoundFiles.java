package Widjets;
import DialogDirector.DialogDirector;
import javax.swing.*;
import Command.Command;
/**
 * Created by Дмитрий33 on 12.03.2017.
 */
public class ListOfFoundFiles extends JList implements Command {

    DialogDirector mediator;

    public ListOfFoundFiles(DialogDirector m) {
        mediator = m;
        mediator.registerListOfFoundFiles(this);
    }

    public void execute() {
    }
}
