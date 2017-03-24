import Window.Window;
import java.awt.Toolkit;
/**
 * Created by Дмитрий33 on 16.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
        int heightScreen =   Toolkit.getDefaultToolkit().getScreenSize().height;
        int widthWind = widthScreen * 2 / 3;
        int heightWind = heightScreen * 2 / 3;

        Window mainWind = new Window(widthWind, heightWind);
        mainWind.setLocation((widthScreen - widthWind) / 2, (heightScreen - heightWind) / 2);
        mainWind.setVisible(true);
    }
}



