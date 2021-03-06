import Controller.MainController;
import Model.AgendaModel;
import View.MainView;

import javax.swing.*;

/**
 * Created by Group11 on 25/02/14.
 * <p/>
 * This is the point of entry of the app
 */
public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
        }


        AgendaModel model = AgendaModel.getModelWithExampleData();
        MainView mainView = new MainView(model);

        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainView.pack();
        mainView.setSize(800, 800);
        mainView.setVisible(true);

        MainController mainViewController = new MainController(model, mainView);
    }
}
