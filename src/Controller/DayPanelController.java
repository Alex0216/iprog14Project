package Controller;

import Model.Activity;
import Model.AgendaModel;
import Model.Day;
import View.ActivityCellRenderer;
import View.ActivityJList;
import View.DayPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alexandre on 25/02/14.
 */
public class DayPanelController implements ChangeListener, ListDataListener, MouseListener {

    AgendaModel model;
    Day day;
    DayPanel view;

    public DayPanelController(AgendaModel model, Day day, DayPanel view) {
        this.model = model;
        this.view = view;
        this.day = day;
        new ActivityTransferListController(view.getListDayActivities(), day, model);
        this.view.getListDayActivities().setCellRenderer(new ActivityCellRenderer(ActivityCellRenderer.START_TIME));
        this.view.getListDayActivities().addMouseListener(this);

        this.view.getTimeSpinner().addChangeListener(this);
        this.view.getListDayActivities().getModel().addListDataListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ActivityJList list = (ActivityJList) e.getSource();
        if (e.getClickCount() == 2) {
            int index = list.locationToIndex(e.getPoint());
            Activity selectedActivity = (Activity) view.getListDayActivities().getModel().getElementAt(index);
            // Open up EditActivityController with selected Activity
            EditActivityController controller = new EditActivityController(this.model, selectedActivity);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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

    @Override
    public void intervalAdded(ListDataEvent e) {
        DefaultListModel<Activity> listModel = (DefaultListModel<Activity>) e.getSource();
        Activity act = listModel.get(e.getIndex0());

    }

    @Override
    public void intervalRemoved(ListDataEvent e) {

    }

    @Override
    public void contentsChanged(ListDataEvent e) {

    }
}
