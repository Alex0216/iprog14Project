package View;

import Model.Activity;
import Model.AgendaModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by group11 on 25/02/14.
 * This view correspond to the leftmost column of the Main windows. There is a
 * button to add new activities and a container containing the different
 * activityView. In this container the activityView should show the duration of
 * the activity.
 */
public class ActivityBankPanel extends JPanel implements Observer {

    private JButton btnAddActivity;
    private ActivityJList listActivities;
    private AgendaModel model;

    /**
     * Create the panel.
     */
    public ActivityBankPanel(AgendaModel model) {
        setLayout(new BorderLayout(300, 10));

        listActivities = new ActivityJList(model.getParkedActivites());
        listActivities.setCellRenderer(new ActivityCellRenderer(ActivityCellRenderer.DURATION, null));
        add(listActivities, BorderLayout.CENTER);

        btnAddActivity = new JButton("+ Add activity");
        btnAddActivity.setForeground(new Color(255, 255, 255));
        btnAddActivity.setBackground(new Color(0, 178, 34));
        add(btnAddActivity, BorderLayout.NORTH);

        this.model = model;
        // add view as observer to the model
        this.model.addObserver(this);
    }

    public ActivityJList getListActivities() {
        return listActivities;
    }

    public JButton getBtnAddActivity() {
        return btnAddActivity;
    }

    // Called by the model
    @Override
    public void update(Observable o, Object arg) {
        // load all activities
        this.listActivities.removeAll();
        DefaultListModel<Activity> listModel = new DefaultListModel<Activity>();
        for (Activity a : model.getParkedActivites())
            listModel.addElement(a);
        //find a way to add all activity in the listModel
        this.listActivities.setModel(listModel);
        this.listActivities.invalidate();

    }


}
