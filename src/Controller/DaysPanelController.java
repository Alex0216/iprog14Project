package Controller;

import Model.AgendaModel;
import Model.Day;
import View.DayPanel;
import View.DaysPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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


        for (int i = 0; i < model.getNbDays(); ++i) {
            addDay(model.getDay(i));
        }
    }


    @Override
    public void update(Observable o, Object arg) {

    }

    public void addDay(Day day) {
        DayPanel dayView = this.daysView.addDayPanel(day);
        DayPanelController dayPanelController = new DayPanelController(this.agendaModel, day, dayView);
        this.dayPanelControllerList.add(dayPanelController);
    }
}
