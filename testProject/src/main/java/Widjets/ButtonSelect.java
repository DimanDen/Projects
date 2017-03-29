/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ButtonSelect.java                                        *
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
