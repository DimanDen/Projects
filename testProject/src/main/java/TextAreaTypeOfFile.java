import javax.swing.*;

/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class TextAreaTypeOfFile extends JTextArea implements Command {
    DialogDirector mediator;

    TextAreaTypeOfFile(DialogDirector m, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerTextAreaTypeOfFile(this);
        this.setBounds(x,y,width,height);
    }

    public void execute() {
    }
}
