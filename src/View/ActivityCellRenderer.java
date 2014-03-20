package View;

import Model.Activity;
import Model.Day;

import javax.swing.*;
import java.awt.*;

/**
 * Created by group11 on 25/02/14.
 * This the view representing an activity that is draggable. It shows the name
 * of the activity, the duration or the start time of the activity depending
 * where the view is. The view also has a color corresponding to the activity.
 * Clicking an activity should bring the EditActivityFrame
 */
public class ActivityCellRenderer extends JPanel implements ListCellRenderer {

    public static final int START_TIME = 0;
    public static final int DURATION = 1;

    private JLabel lblTime;
    private JLabel lblName;
    private int format;

    Day day;

    public ActivityCellRenderer(int format, Day day) {
        setLayout(new BorderLayout(10, 10));
        this.format = format;
        lblTime = new JLabel("Time");
        lblTime.setHorizontalAlignment(SwingConstants.CENTER);
        lblTime.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTime, BorderLayout.WEST);

        lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblName, BorderLayout.CENTER);
        this.day = day;
    }

    /*
    This is the method we have to override the customize how the activity will
    look like in a JList
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Activity activity = (Activity) value;

        //The activity can either show the duration or the start time of the activity
        //If the ActivityJList is being used in a DayPanel, the start time is shown
        //If the ActivityJList is being used in a ActivityBankPanel, the duration is shown
        String time;
        switch (format) {
            case START_TIME:
                int sum = 0;
                for (int i = 0; i < index; ++i) {
                    sum += ((ActivityJList) list).getModel().getElementAt(i).getLength();
                }
                int startTime = day.getStart() + sum;
                String hour = String.valueOf(startTime / 60);
                String minutes = String.valueOf(startTime % 60);
                if (minutes.length() == 1)
                    minutes = minutes.concat("0");
                time = hour + ":" + minutes;
                break;
            case DURATION:
            default:
                time = String.valueOf(activity.getLength()) + " min";

        }
        lblTime.setText(time);
        lblName.setText(activity.getName());


        //Set the color of the cell depending on the activity type
        switch (activity.getType()) {
            case Activity.BREAK:
                setBackground(ColorScheme.COLOR_BREAK);
                break;
            case Activity.PRESENTATION:
                setBackground(ColorScheme.COLOR_PRESENTATION);
                break;
            case Activity.DISCUSSION:
                setBackground(ColorScheme.COLOR_DISCUSSION);
                break;
            case Activity.GROUP_WORK:
                setBackground(ColorScheme.COLOR_GROUP_WORK);
                break;
            default:
                setBackground(list.getBackground());
                setForeground(list.getForeground());
        }
        if (isSelected) {
            setBorder(BorderFactory.createLineBorder(Color.BLACK));

        } else {
            setBorder(BorderFactory.createEmptyBorder());
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;

    }

    public JLabel getLblTime() {
        return lblTime;
    }

    public JLabel getLblName() {
        return lblName;
    }

}
