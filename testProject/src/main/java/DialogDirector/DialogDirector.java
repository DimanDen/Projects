package DialogDirector;

import Widjets.*;

/**
 * Created by Дмитрий33 on 09.03.2017.
 */
public interface DialogDirector {
    //Methods
    void write(); //Write data from selected files
    void search(); //Search in directory for files
    void select(); //Move files from "found" to "selected for write"
    void delete(); //Delete selected files from lists

    void registerWrite(ButtonWrite buttonWrite); //Register object of ButtonWrite
    void registerSearch(ButtonSearch buttonSearch); //Register object of ButtonSearch
    void registerSelect(ButtonSelect buttonSelect); //Register object of ButtonSelect
    void registerDelete(ButtonDelete buttonDelete); //Register object of ButtonDelete

    void registerListOfFoundFiles(ListOfFoundFiles listOfFoundFiles); //Register object of ListOfFoundFiles
    void registerScrollPaneListOfFoundFiles(ScrollPaneListOfFoundFiles scrollPaneListOfFoundFiles);//Register object of
    //ScrollPaneListOfFoundFiles

    void registerListOfSelectedFiles(ListOfSelectedFiles listOfSelectedFiles); //Register object of ListOfSelectedFiles
    void registerScrollPaneListOfSelectedFiles(ScrollPaneListOfSelectedFiles scrollPaneListOfSelectedFiles);//Register
    //object of ScrollPaneListOfSelectedFiles

    void registerTextAreaTypeOfFile(TextAreaTypeOfFile textAreaTypeOfFile); //Register object of TextAreaTypeOfFile
    void registerLabelTypeOfFile(LabelTypeOfFile labelTypeOfFile); //Register object of LabelTypeOfFile
} //End of interface DialogDirector.DialogDirector
