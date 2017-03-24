package Widjets;
import Command.Command;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import DialogDirector.DialogDirector;

/**
 * Created by Дмитрий33 on 11.03.2017.
 */
//A concrete colleague
public class ButtonWrite extends JButton implements Command {

    // Fields
    DialogDirector mediator;

    //Constructor
    public ButtonWrite(ActionListener actionListener, DialogDirector m, int x, int y, int width, int height) {
        super("Записать выбранные файлы");
        addActionListener(actionListener);
        mediator = m;
        mediator.registerWrite(this);
        this.setBounds(x,y,width,height);
    }// End of Constructor

    //Methods
    public void execute() {
        mediator.write();
    }// End of execute()
} //End of Widjets.ButtonWrite