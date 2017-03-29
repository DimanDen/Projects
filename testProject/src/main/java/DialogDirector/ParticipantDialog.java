/****************************************************************************
 *                  КУРС СОВРЕМЕННЫХ ПРОБЛЕМ ИНФОРМАТИКИ                    *
 *--------------------------------------------------------------------------*
 * Project Type  : Graphical application                                    *
 * Project Name  : ProgramForCreatingListing                                *
 * Language      : Java Version 8 Update 121                                *
 * File Name     : DialogDirector.java                                      *
 * Programmer(s) : Денщиков Д.А.                                            *
 * Modified By   : Денщиков Д.А.                                            *
 * Created       : 06/03/17                                                 *
 * Last Revision : 30/03/17                                                 *
 * Comment(s)    : Интерфейс, содержащий методы регистрации объектов        *
 *                 и методы, определяющие действия по нажатию на кнопки     *
 *                                                                          *
 ****************************************************************************/

package DialogDirector;

import Logic.ActionLogic;
import Widjets.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Дмитрий33 on 09.03.2017.
 */
public class ParticipantDialog implements DialogDirector {
    //Fields

    //Graphic elements->
    ButtonSelect buttonSelect;
    ButtonDelete buttonDelete;
    ButtonSearch buttonSearch;
    ButtonWrite buttonWrite;

    DefaultListModel listModel_FoundFiles = new DefaultListModel();
    DefaultListModel listModel_SelectedFiles = new DefaultListModel();

    ListOfFoundFiles listOfFoundFiles;
    ListOfSelectedFiles listOfSelectedFiles;

    ScrollPaneListOfFoundFiles scrollPaneListOfFoundFiles;
    ScrollPaneListOfSelectedFiles scrollPaneListOfSelectedFiles;

    TextAreaTypeOfFile textAreaTypeOfFile;

    LabelTypeOfFile labelTypeOfFile;
    //<-Graphic elements

    ActionLogic actionLogic = new ActionLogic(); //Created for determine action for buttons

    //Methods
    //Register methods->
    @Override
    public void registerSearch(ButtonSearch buttonSearch) {
        this.buttonSearch = buttonSearch;
    }

    @Override
    public void registerWrite(ButtonWrite buttonWrite) {
        this.buttonWrite = buttonWrite;
        this.buttonWrite.setEnabled(false);
    }

    @Override
    public void registerSelect(ButtonSelect buttonSelect) {
        this.buttonSelect = buttonSelect;
    }

    @Override
    public void registerDelete(ButtonDelete buttonDelete) {
        this.buttonDelete = buttonDelete;
        this.buttonDelete.setEnabled(false);
    }

    @Override
    public void registerListOfFoundFiles(ListOfFoundFiles listOfFoundFiles){
        this.listOfFoundFiles = listOfFoundFiles;
        this.listOfFoundFiles.setModel(listModel_FoundFiles);
    }

    @Override
    public void registerScrollPaneListOfFoundFiles(ScrollPaneListOfFoundFiles scrollPaneListOfFoundFiles) {
        this.scrollPaneListOfFoundFiles = scrollPaneListOfFoundFiles;
        this.scrollPaneListOfFoundFiles.setViewportView(listOfFoundFiles);
    }

    @Override
    public void registerListOfSelectedFiles(ListOfSelectedFiles listOfSelectedFiles) {
        this.listOfSelectedFiles = listOfSelectedFiles;
        this.listOfSelectedFiles.setModel(listModel_SelectedFiles);
    }

    @Override
    public void registerScrollPaneListOfSelectedFiles(ScrollPaneListOfSelectedFiles scrollPaneListOfSelectedFiles) {
        this.scrollPaneListOfSelectedFiles = scrollPaneListOfSelectedFiles;
        this.scrollPaneListOfSelectedFiles.setViewportView(listOfSelectedFiles);
    }

    @Override
    public void registerTextAreaTypeOfFile(TextAreaTypeOfFile textAreaTypeOfFile) {
        this.textAreaTypeOfFile = textAreaTypeOfFile;
    }

    @Override
    public void registerLabelTypeOfFile(LabelTypeOfFile labelTypeOfFile) {
        this.labelTypeOfFile = labelTypeOfFile;
    }

    //<-Register methods

    public void write() {
        ArrayList selectedFiles = new ArrayList(); //local array

        for (int i = 0; i < listModel_SelectedFiles.size(); i++) {
            selectedFiles.add(listModel_SelectedFiles.get(i)); //form local array, which consist of selected files from
            //lists
        }

        actionLogic.writeToFileSelectedElements(selectedFiles //Write data to file
                , "");//textAr_Delimiter.getText());
        JOptionPane.showMessageDialog(null, "Успешно записано!"); //Show message of successful complete operation
    }// End of write()

    public void search() {
        ArrayList elements = actionLogic.getListOfFiles(textAreaTypeOfFile.getText()); //local array of found Files
        for (int i = 0; i < elements.size(); i++) {
            listModel_FoundFiles.addElement(elements.get(i).toString()); //add found files to list
        }

        if(listModel_SelectedFiles.size() != 0 || listModel_FoundFiles.size() != 0) { //if lists have more than 0 files
            buttonDelete.setEnabled(true);
        }
    }// End of search()

    public void select() {
        int[] arrayOfSelected = listOfFoundFiles.getSelectedIndices(); //local array of selected files
        for (int i = 0; i < arrayOfSelected.length; i++) {
            listModel_SelectedFiles.addElement(listModel_FoundFiles.get(arrayOfSelected[i])); //move selected files
            //from "found" list to "selected for write" list
        }
        if(listModel_SelectedFiles.size() != 0) {
            buttonWrite.setEnabled(true);
        }
    }// End of select

    public void delete() {
        int[] arrayOfSelected = listOfSelectedFiles.getSelectedIndices();
        for (int i = 0; i < arrayOfSelected.length; i++) {
            listModel_SelectedFiles.remove(listOfSelectedFiles.getSelectedIndex()); //remove all selected files
        }

        int[] arrayOfFound = listOfFoundFiles.getSelectedIndices();
        for (int i = 0; i < arrayOfFound.length; i++) {
            listModel_FoundFiles.remove(listOfFoundFiles.getSelectedIndex()); //remove all selected files
        }

        if(listModel_SelectedFiles.size() == 0) {
            buttonWrite.setEnabled(false);
            if (listModel_FoundFiles.size() == 0) {
                buttonDelete.setEnabled(false);
            }
        }

    }// End of delete()
}// End of ParticipantDialog
