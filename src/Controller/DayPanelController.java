package Controller;

import Model.AgendaModel;
import Model.Day;
import View.ActivityCellRenderer;
import View.DayPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alexandre on 25/02/14.
 */
public class DayPanelController implements ChangeListener {

    AgendaModel model;
    Day day;
    DayPanel view;

    public DayPanelController(AgendaModel model, Day day, DayPanel view) {
        this.model = model;
        this.view = view;
        this.day = day;
        new ActivityTransferListController(view.getListDayActivities());
        this.view.getListDayActivities().setCellRenderer(new ActivityCellRenderer(ActivityCellRenderer.START_TIME));

        this.view.getTimeSpinner().addChangeListener(this);
    }

    int prevDate = 0;

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(view.getTimeSpinner())) {
            Date date = (Date) view.getTimeSpinner().getValue();
            Calendar c = Calendar.getInstance();
            c.setTime(date);

            int minutes = c.get(Calendar.MINUTE) + c.get(Calendar.HOUR_OF_DAY) * 60;
            if (prevDate != minutes) {
                day.setStart(minutes);
            }
            prevDate = minutes;
        }
    }
}
