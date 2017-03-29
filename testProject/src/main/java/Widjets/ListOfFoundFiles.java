/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ListOfFoundFiles.java                                    *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Класс, инициализирующий графический объект списка        *
 *                                                                          *
 *                                                                          *
 ****************************************************************************/

package Widjets;
import DialogDirector.DialogDirector;
import javax.swing.*;
import Command.Command;
/**
 * Created by Дмитрий33 on 12.03.2017.
 */
public class ListOfFoundFiles extends JList implements Command {

    DialogDirector mediator;

    public ListOfFoundFiles(DialogDirector m) {
        mediator = m;
        mediator.registerListOfFoundFiles(this);
    }

    public void execute() {
    }
}
