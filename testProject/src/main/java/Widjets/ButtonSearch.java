/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ButtonSearch.java                                        *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Класс, инициализирующий графический объект кнопки        *
 *                                                                          *
 *                                                                          *
 ****************************************************************************/

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
        super("Поиск файлов в директории");
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
