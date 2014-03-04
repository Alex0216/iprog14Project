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
    	MainView mainView = new MainView();
    	
    	JFrame window = mainView;
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setSize(800, 800);
        window.setVisible(true);
        
        MainController mainViewController = new MainController(AgendaModel.getModelWithExampleData(), mainView);
    }
}
