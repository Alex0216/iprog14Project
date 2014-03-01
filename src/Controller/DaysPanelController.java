package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Model.AgendaModel;
import View.DayPanel;
import View.DaysPanel;

/**
 * Created by Yeonni on 02/03/14.
 */
public class DaysPanelController implements Observer {

	private AgendaModel agendaModel;
	private DaysPanel daysView;
	private List<DayPanelController> dayPanelControllerList;
	
    public DaysPanelController(AgendaModel model, DaysPanel view) {
    	model.addObserver(this);
    	this.agendaModel = model;
    	this.daysView = view;
    	this.dayPanelControllerList = new ArrayList<DayPanelController>();
    	
    	DayPanelController dayPanelController;
    	for (DayPanel dayView : view.dayPanelList) {
    		dayPanelController = new DayPanelController(agendaModel, dayView);
    		dayPanelControllerList.add(dayPanelController);
    	}
    }


	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof AgendaModel) {
			AgendaModel model = (AgendaModel) o;
			if (arg.equals(AgendaModel.notificationMsgDayAdded)) {
				DayPanel dayView = this.daysView.addDayPanel();
				DayPanelController dayPanelController = new DayPanelController(this.agendaModel, dayView);
				this.dayPanelControllerList.add(dayPanelController);
			}
			
		}
	}

}
