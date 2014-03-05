package View;

import Model.Activity;
import Model.Day;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Group11 on 25/02/14.
 * This is the view representing a day You can drop activityView in it. The view
 * should show the start time of the day, its end time and its total length. A
 * box should show a quick overview of the day's scheduled. When dropped in this
 * view, the activityView should show the time at which the activity is starting
 */
public class DayPanel extends JPanel implements Observer {
    private JTextField textField;
    private JSpinner timeSpinner;
    private JLabel lblEndTime;
    private JLabel lblTotalTime;
    private ActivityJList listDayActivities;


    public DayPanel(Day day) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblStartTime = new JLabel("Start Time:");
        GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
        gbc_lblStartTime.insets = new Insets(0, 0, 5, 5);
        gbc_lblStartTime.gridx = 0;
        gbc_lblStartTime.gridy = 0;
        add(lblStartTime, gbc_lblStartTime);

        timeSpinner = new JSpinner();
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MINUTE, day.getStart() % 60);
        c.set(Calendar.HOUR_OF_DAY, day.getStart() / 60);
        dateModel.setValue(c.getTime());
        timeSpinner.setModel(dateModel);
        JSpinner.DateEditor de_timeSpinner = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        de_timeSpinner.getTextField().setEditable(false);
        timeSpinner.setEditor(de_timeSpinner);
        GridBagConstraints gbc_timeSpinner = new GridBagConstraints();
        gbc_timeSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_timeSpinner.gridx = 1;
        gbc_timeSpinner.gridy = 0;
        add(timeSpinner, gbc_timeSpinner);

        JLabel lblEndTimetmp = new JLabel("End Time:");
        GridBagConstraints gbc_lblEndTimetmp = new GridBagConstraints();
        gbc_lblEndTimetmp.insets = new Insets(0, 0, 5, 5);
        gbc_lblEndTimetmp.gridx = 0;
        gbc_lblEndTimetmp.gridy = 1;
        add(lblEndTimetmp, gbc_lblEndTimetmp);

        lblEndTime = new JLabel();
        String hour = String.valueOf(day.getEnd() / 60);
        String minutes = String.valueOf(day.getEnd() % 60);
        if (minutes.length() == 1)
            minutes = minutes.concat("0");
        lblEndTime.setText(hour + ":" + minutes);
        GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
        gbc_lblEndTime.insets = new Insets(0, 0, 5, 5);
        gbc_lblEndTime.gridx = 1;
        gbc_lblEndTime.gridy = 1;
        add(lblEndTime, gbc_lblEndTime);

        JLabel lblTotalTimetmp = new JLabel("Total Time:");
        GridBagConstraints gbc_lblTotalTimetmp = new GridBagConstraints();
        gbc_lblTotalTimetmp.insets = new Insets(0, 0, 5, 5);
        gbc_lblTotalTimetmp.gridx = 0;
        gbc_lblTotalTimetmp.gridy = 2;
        add(lblTotalTimetmp, gbc_lblTotalTimetmp);

        lblTotalTime = new JLabel();
        lblTotalTime.setText(String.valueOf(day.getTotalLength()) + " minutes");
        GridBagConstraints gbc_lblTotalTime = new GridBagConstraints();
        gbc_lblTotalTime.insets = new Insets(0, 0, 5, 5);
        gbc_lblTotalTime.gridx = 1;
        gbc_lblTotalTime.gridy = 2;
        add(lblTotalTime, gbc_lblTotalTime);

        listDayActivities = new ActivityJList(day.getActivities());
        listDayActivities.setCellRenderer(new ActivityCellRenderer(ActivityCellRenderer.START_TIME));


        GridBagConstraints gbc_listDayActivities = new GridBagConstraints();
        gbc_listDayActivities.gridwidth = 3;
        gbc_listDayActivities.fill = GridBagConstraints.BOTH;
        gbc_listDayActivities.gridx = 0;
        gbc_listDayActivities.gridy = 3;
        add(listDayActivities, gbc_listDayActivities);

        day.addObserver(this);
    }

    public JSpinner getTimeSpinner() {
        return timeSpinner;
    }

    public JLabel getLblTotalTime() {
        return lblTotalTime;
    }

    public JLabel getLblEndTime() {
        return lblEndTime;
    }

    public ActivityJList getListDayActivities() {
        return listDayActivities;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Day) {
            Day day = (Day) o;
            //EndTime
            String hour = String.valueOf(day.getEnd() / 60);
            String minutes = String.valueOf(day.getEnd() % 60);
            if (minutes.length() == 1)
                minutes = minutes.concat("0");
            lblEndTime.setText(hour + ":" + minutes);
            //Length
            lblTotalTime.setText(String.valueOf(day.getTotalLength()) + " minutes");

            //Updating the list
            DefaultListModel<Activity> listModel = new DefaultListModel<Activity>();
            for (Activity a : day.getActivities())
                listModel.addElement(a);
            //find a way to add all activity in the listModel
            this.getListDayActivities().setModel(listModel);
        }
    }
}
