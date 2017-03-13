import javax.swing.*;

/**
 * Created by Дмитрий33 on 12.03.2017.
 */
public class ListOfFoundFiles extends JList implements Command {

    DialogDirector mediator;

    ListOfFoundFiles(DialogDirector m) {
        mediator = m;
        mediator.registerListOfFoundFiles(this);
    }

    public void execute() {
    }
}
