import javax.swing.*;

/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class LabelTypeOfFile extends JLabel implements Command {

    DialogDirector mediator;

    LabelTypeOfFile(DialogDirector m, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerLabelTypeOfFile(this);
        this.setText("Расширение файла");
        this.setBounds(x,y,width,height);
    }

    public void execute() {
    }
}
