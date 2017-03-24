package Widjets;
import DialogDirector.DialogDirector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import Command.Command;
/**
 * Created by Дмитрий33 on 11.03.2017.
 */
public class ButtonSearch extends JButton implements Command {

    //Fields
    DialogDirector mediator;

    //Constructor
    public ButtonSearch(ActionListener al, DialogDirector m, int x, int y, int width, int height) {
        super("Поиск файлов");
        addActionListener(al); //Add action, which will happen after click
        mediator = m;
        mediator.registerSearch(this);//registred element
        this.setBounds(x,y,width,height); //assignment sizes
    }//End of constructor

    //Methods
    public void execute() {
        mediator.search();
    }

}//End of class Button Search
