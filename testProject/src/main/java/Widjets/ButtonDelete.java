/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ButtonDelete.java                                        *
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
import javax.swing.*;
import java.awt.event.ActionListener;
import Command.Command;

/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class ButtonDelete extends JButton implements Command {

    //
    DialogDirector mediator;

    public ButtonDelete(ActionListener al, DialogDirector m, int x, int y, int width, int height) {
        super("Удалить выбранные файлы из списков");
        addActionListener(al);
        mediator = m;
        mediator.registerDelete(this);
        this.setBounds(x, y, width, height);
    }

    public void execute() {
        mediator.delete();
    }
}