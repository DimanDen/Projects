package Widjets;
import Command.Command;
import javax.swing.*;
import java.awt.event.ActionListener;
import DialogDirector.DialogDirector;
/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class ButtonSelect extends JButton implements Command {

    DialogDirector mediator;

    public ButtonSelect(ActionListener al, DialogDirector m, int x, int y, int width, int height) {
        super("Добавить в список файлов, формирующих листинг");
        addActionListener(al);
        mediator = m;
        mediator.registerSelect(this);
        this.setBounds(x,y,width,height);
    }

    public void execute() {
        mediator.select();
    }

}
