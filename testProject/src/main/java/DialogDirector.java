/**
 * Created by Дмитрий33 on 09.03.2017.
 */
public interface DialogDirector {
    void write();
    void search();
    void select();
    void delete();

    void registerWrite(ButtonWrite buttonWrite);
    void registerSearch(ButtonSearch buttonSearch);
    void registerSelect(ButtonSelect buttonSelect);
    void registerDelete(ButtonDelete buttonDelete);

    void registerListOfFoundFiles(ListOfFoundFiles listOfFoundFiles);
    void registerScrollPaneListOfFoundFiles(ScrollPaneListOfFoundFiles scrollPaneListOfFoundFiles);

    void registerListOfSelectedFiles(ListOfSelectedFiles listOfSelectedFiles);
    void registerScrollPaneListOfSelectedFiles(ScrollPaneListOfSelectedFiles scrollPaneListOfSelectedFiles);

    void registerTextAreaTypeOfFile(TextAreaTypeOfFile textAreaTypeOfFile);
    void registerLabelTypeOfFile(LabelTypeOfFile labelTypeOfFile);
}
