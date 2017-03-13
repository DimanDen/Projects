import javax.swing.*;

/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class ScrollPaneListOfSelectedFiles extends JScrollPane implements Command {
    DialogDirector mediator;

    ScrollPaneListOfSelectedFiles(DialogDirector m, ListOfSelectedFiles listOfSelectedFiles, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerScrollPaneListOfSelectedFiles(this);
        this.setViewportView(listOfSelectedFiles);
        this.setBounds(x, y, width, height);
    }

    public void execute() {
    }
}