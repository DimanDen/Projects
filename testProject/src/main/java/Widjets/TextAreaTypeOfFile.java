/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : TextAreaTypeOfFile.java                                  *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Класс, инициализирующий графический объект текстового    *
 *                 поля                                                     *
 *                                                                          *
 ****************************************************************************/

package Widjets;
import Command.Command;
import DialogDirector.DialogDirector;
import javax.swing.*;
/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class TextAreaTypeOfFile extends JTextArea implements Command {
    DialogDirector mediator;

    public TextAreaTypeOfFile(DialogDirector m, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerTextAreaTypeOfFile(this);
        this.setBounds(x,y,width,height);
    }

    public void execute() {
    }
}
