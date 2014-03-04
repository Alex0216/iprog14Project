package View;

import Model.Activity;

import javax.swing.*;
import java.awt.*;

/**
 * Created by group11 on 25/02/14.
 * This view correspond to the leftmost column of the Main windows. There is a
 * button to add new activities and a container containing the different
 * activityView. In this container the activityView should show the duration of
 * the activity.
 */
public class ActivityBankPanel extends JPanel {
    private JButton btnAddActivity;
    private ActivityJList listActivities;

    /**
     * Create the panel.
     */
    public ActivityBankPanel() {
        setLayout(new BorderLayout(300, 10));

        listActivities = new ActivityJList();
        listActivities.setCellRenderer(new ActivityCellRenderer(ActivityCellRenderer.DURATION));


        DefaultListModel<Activity> listModel = (DefaultListModel<Activity>) listActivities.getModel();
        listModel.addElement(new Activity("Introduction", "Intro to the meeting", 10, 0));
        listModel.addElement(new Activity("Idea 1", "Presenting idea 1", 30, 1));

        add(listActivities, BorderLayout.CENTER);

        btnAddActivity = new JButton("+Add activity");
        btnAddActivity.setForeground(new Color(255, 255, 255));
        btnAddActivity.setBackground(new Color(0, 178, 34));
        add(btnAddActivity, BorderLayout.NORTH);


    }

    public ActivityJList getListActivities() {
        return listActivities;
    }


    public JButton getBtnAddActivity() {
        return btnAddActivity;
    }
}
