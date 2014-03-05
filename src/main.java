import Controller.MainController;
import Model.AgendaModel;
import View.MainView;

import javax.swing.*;

/**
 * Created by Group11 on 25/02/14.
 * <p/>
 * This is the point of entry of the app
 */
public class main {

    public static void main(String[] args) {
        MainView mainView = new MainView(AgendaModel.getModelWithExampleData());

        JFrame window = mainView;
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        
        MainController mainViewController = new MainController(AgendaModel.getModelWithExampleData(), mainView);
    }
}
