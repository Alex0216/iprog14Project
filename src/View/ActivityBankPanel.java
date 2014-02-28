package View;

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
    private JList listActivities;

    /**
     * Create the panel.
     */
    public ActivityBankPanel() {
        setLayout(new BorderLayout(300, 10));

        listActivities = new activityJList();

        add(listActivities, BorderLayout.CENTER);

        btnAddActivity = new JButton("+Add activity");
        btnAddActivity.setForeground(new Color(255, 255, 255));
        btnAddActivity.setBackground(new Color(0, 178, 34));
        add(btnAddActivity, BorderLayout.NORTH);

    }

    public JList getListActivities() {
        return listActivities;
    }


    public JButton getBtnAddActivity() {
        return btnAddActivity;
    }
}
