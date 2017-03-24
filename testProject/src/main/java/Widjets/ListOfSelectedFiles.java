package Widjets;
import DialogDirector.DialogDirector;
import javax.swing.*;
import Command.Command;
/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class ListOfSelectedFiles extends JList implements Command {

    DialogDirector mediator;

    public ListOfSelectedFiles(DialogDirector m) {
        mediator = m;
        mediator.registerListOfSelectedFiles(this);
    }

    public void execute() {
    }
}