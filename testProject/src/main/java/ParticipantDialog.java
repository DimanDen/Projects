import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Дмитрий33 on 09.03.2017.
 */
public class ParticipantDialog implements DialogDirector {
    ButtonWrite buttonWrite;
    ButtonSearch buttonSearch;
    ButtonSelect buttonSelect;
    ButtonDelete buttonDelete;

    DefaultListModel listModel_FoundFiles = new DefaultListModel();
    DefaultListModel listModel_SelectedFiles = new DefaultListModel();

    ListOfFoundFiles listOfFoundFiles;
    ListOfSelectedFiles listOfSelectedFiles;

    ScrollPaneListOfFoundFiles scrollPaneListOfFoundFiles;
    ScrollPaneListOfSelectedFiles scrollPaneListOfSelectedFiles;

    TextAreaTypeOfFile textAreaTypeOfFile;

    LabelTypeOfFile labelTypeOfFile;

    ActionLogic actionLogic = new ActionLogic();

    //....
    @Override
    public void registerWrite(ButtonWrite btnView) {
        this.buttonWrite = btnView;
    }

    @Override
    public void registerSearch(ButtonSearch btnSearch) {
        this.buttonSearch = btnSearch;
    }

    @Override
    public void registerSelect(ButtonSelect btnSelect) {
        this.buttonSelect = btnSelect;
    }

    @Override
    public void registerDelete(ButtonDelete buttonDelete) {
        this.buttonDelete = buttonDelete;
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

    public void write() {
        ArrayList selectedFiles = new ArrayList();

        for (int i = 0; i < listModel_SelectedFiles.size(); i++) {
            selectedFiles.add(listModel_SelectedFiles.get(i));
        }

        actionLogic.writeToFileSelectedElements(selectedFiles
                , "ssssss");//textAr_Delimiter.getText());
        JOptionPane.showMessageDialog(null, "Успешно записано!");
    }

    public void search() {
        ArrayList elements = actionLogic.getListOfFiles(textAreaTypeOfFile.getText());
        for (int i = 0; i < elements.size(); i++) {
            listModel_FoundFiles.addElement(elements.get(i).toString());
        }
    }

    public void select() {
        int[] arrayOfChoosen = listOfFoundFiles.getSelectedIndices();
        for (int i = 0; i < arrayOfChoosen.length; i++) {
            listModel_SelectedFiles.addElement(listModel_FoundFiles.get(arrayOfChoosen[i]));
        }
    }

    public void delete() {
        int[] arrayOfSelected = listOfSelectedFiles.getSelectedIndices();
        for (int i = 0; i < arrayOfSelected.length; i++) {
            listModel_SelectedFiles.remove(listOfSelectedFiles.getSelectedIndex());
        }

        int[] arrayOfFound = listOfFoundFiles.getSelectedIndices();
        for (int i = 0; i < arrayOfFound.length; i++) {
            listModel_FoundFiles.remove(listOfFoundFiles.getSelectedIndex());
        }
    }
}
