package Controller;

import Model.Activity;
import Model.AgendaModel;
import View.ActivityBankPanel;
import View.ActivityJList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Alexandre on 25/02/14.
 */
public class ActivityBankController implements ActionListener, MouseListener, ListSelectionListener {

    private AgendaModel model;
	private ActivityBankPanel view;

    public ActivityBankController(AgendaModel model, ActivityBankPanel view) {
        this.model = model;
        this.view = view;
        new ActivityTransferListController(this.view.getListActivities(), model);
        // attach listeners to "Add Activity" - Button
		view.getBtnAddActivity().addActionListener(this);
		view.getListActivities().addMouseListener(this);
		// TODO: perhaps add some possibility to change a given activity?


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// controller pops up EditActivityFrame-view
		// EditActivityController editViewController = new EditActivityController(model, new EditActivityFrame());
        EditActivityController controller = new EditActivityController(this.model);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        ActivityJList list = (ActivityJList) e.getSource();
        if (e.getClickCount() == 2) {
            int index = list.locationToIndex(e.getPoint());
            Activity selectedActivity = (Activity)view.getListActivities().getModel().getElementAt(index);
            // Open up EditActivityController with selected Activity
            EditActivityController controller = new EditActivityController(this.model, selectedActivity);
        }
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (view.getListActivities().getSelectedIndex() == -1) {
                //No selection, disable fire button.
                return;

            } else {
                //Selection, enable the fire button.
                Activity selectedActivity = view.getListActivities().getSelectedValue();
                EditActivityController controller = new EditActivityController(this.model, selectedActivity);
            }
        }

    }
}
