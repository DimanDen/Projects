/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ButtonWrite.java                                        *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Класс, инициализирующий графический объект кнопки        *
 *                                                                          *
 *                                                                          *
 ****************************************************************************/

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
        super("Записать выбранные файлы в текстовый файл");
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