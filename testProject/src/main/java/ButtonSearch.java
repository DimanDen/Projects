import javax.swing.JButton;
import java.awt.event.ActionListener;
/**
 * Created by Дмитрий33 on 11.03.2017.
 */
public class ButtonSearch extends JButton implements Command {

    DialogDirector mediator;

    ButtonSearch(ActionListener al, DialogDirector m, int x, int y, int width, int height) {
        super("Поиск файлов");
        addActionListener(al);
        mediator = m;
        mediator.registerSearch(this);
        this.setBounds(x,y,width,height);
    }

    public void execute() {
        mediator.search();
    }

}
