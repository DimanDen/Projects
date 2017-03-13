import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class ButtonDelete extends JButton implements Command {

    DialogDirector mediator;

    ButtonDelete(ActionListener al, DialogDirector m, int x, int y, int width, int height) {
        super("Удалить выбранные файлы");
        addActionListener(al);
        mediator = m;
        mediator.registerDelete(this);
        this.setBounds(x, y, width, height);
    }

    public void execute() {
        mediator.delete();
    }
}