/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ScrollPaneListOfSelectedFiles.java                       *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Класс, инициализирующий графический объект скроллинга    *
 *                                                                          *
 *                                                                          *
 ****************************************************************************/

package Widjets;
import DialogDirector.DialogDirector;
import javax.swing.*;
import Command.Command;
/**
 * Created by Дмитрий33 on 13.03.2017.
 */
public class ScrollPaneListOfSelectedFiles extends JScrollPane implements Command {
    DialogDirector mediator;

    public ScrollPaneListOfSelectedFiles(DialogDirector m, ListOfSelectedFiles listOfSelectedFiles, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerScrollPaneListOfSelectedFiles(this);
        this.setViewportView(listOfSelectedFiles);
        this.setBounds(x, y, width, height);
    }

    public void execute() {
    }
}