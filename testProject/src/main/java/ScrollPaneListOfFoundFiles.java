import javax.swing.*;

/**
 * Created by Дмитрий33 on 12.03.2017.
 */
public class ScrollPaneListOfFoundFiles extends JScrollPane implements Command{
    DialogDirector mediator;

    ScrollPaneListOfFoundFiles(DialogDirector m, ListOfFoundFiles listOfFoundFiles, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerScrollPaneListOfFoundFiles(this);
        this.setViewportView(listOfFoundFiles);
        this.setBounds(x,y,width,height);
    }

    public void execute() {
    }
}
