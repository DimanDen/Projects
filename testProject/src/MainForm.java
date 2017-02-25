import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Дмитрий33 on 21.02.2017.
 */
public class MainForm {
    public JButton AnalysisDirectoryBtn;
    public JPanel panelMain;
    public JList listOfFiles;
    private JTextArea textFileType;

    public DefaultListModel listModel = new DefaultListModel(); //Создание модели списка


    public MainForm() {
//        AnalysisDirectoryBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                DirectoryWorker.analysisDirectory();
//                ArrayList elements = DirectoryWorker.listOfFiles;
//                for(int i = 0; i < elements.size(); i ++)
//                {
//                    listModel.addElement(elements.get(i).toString());
//                }
//                panelMain.updateUI();
//            }
//        });
    }
}
