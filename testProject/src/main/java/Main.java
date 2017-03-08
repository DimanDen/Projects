import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Дмитрий33 on 16.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        int widthScreen = 1920;
        int heightScreen = 1080;
        int widthWind = widthScreen * 2 / 3;
        int heightWind = heightScreen * 2 / 3;

        Window mainWind = new Window(widthScreen, heightScreen);
        mainWind.setBounds((widthScreen-widthWind)/2, (heightScreen-heightWind)/2, widthWind, heightWind);
        mainWind.setVisible(true);
    }
}



