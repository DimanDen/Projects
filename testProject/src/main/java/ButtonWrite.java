import javax.swing.JButton;
import java.awt.event.ActionListener;

/**
 * Created by Дмитрий33 on 11.03.2017.
 */
//A concrete colleague
public class ButtonWrite extends JButton implements Command {

    DialogDirector mediator;

    ButtonWrite(ActionListener actionListener, DialogDirector m, int x, int y, int width, int height) {
        super("Записать выбранные файлы");
        addActionListener(actionListener);
        mediator = m;
        mediator.registerWrite(this);
        this.setBounds(x,y,width,height);
    }

    public void execute() {
        mediator.write();
    }
}