package Controller;

import Model.AgendaModel;
import View.DaysPanel;
import View.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexandre on 25/02/14.
 */
public class MainController implements ActionListener {

	private MainView mainView;
	private AgendaModel agendaModel;
	
	private DaysPanelController daysPanelController;
	private ActivityBankController activityBankController;
	
    public MainController(AgendaModel model, MainView view) {
    	this.mainView = view;
    	this.agendaModel = model;
    	
    	this.mainView.addBtnAddDayActionListener(this);
    	
    	DaysPanel daysView = mainView.getDaysPanel();
    	this.daysPanelController = new DaysPanelController(this.agendaModel, daysView);

        this.activityBankController = new ActivityBankController(this.agendaModel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.mainView.isBtnAddDay(e.getSource())) {
        	this.agendaModel.addDay(8, 0);
        }
    }
}
