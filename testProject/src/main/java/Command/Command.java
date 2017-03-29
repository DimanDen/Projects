/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : Command.java                                             *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Интерфейс, содержащий метод, определяющий действия       *
 *                 совершаемые объектом, при взаимодействии с ним           *
 *                                                                          *
 ****************************************************************************/
package Command;

/**
 * Created by Дмитрий33 on 11.03.2017.
 */
public interface Command {
    //Methods
    void execute(); //Determine operations which will complete when action passed
}//End of interface