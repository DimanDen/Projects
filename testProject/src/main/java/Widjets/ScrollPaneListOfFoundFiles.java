/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : ScrollPaneListOfFoundFiles.java                          *
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
 * Created by Дмитрий33 on 12.03.2017.
 */
public class ScrollPaneListOfFoundFiles extends JScrollPane implements Command {
    DialogDirector mediator;

    public ScrollPaneListOfFoundFiles(DialogDirector m, ListOfFoundFiles listOfFoundFiles, int x, int y, int width, int height) {
        mediator = m;
        mediator.registerScrollPaneListOfFoundFiles(this);
        this.setViewportView(listOfFoundFiles);
        this.setBounds(x,y,width,height);
    }

    public void execute() {
    }
}
