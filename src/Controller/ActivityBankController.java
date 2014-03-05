package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JList;

import Model.Activity;
import Model.AgendaModel;
import View.ActivityBankPanel;

/**
 * Created by Alexandre on 25/02/14.
 */
public class ActivityBankController implements ActionListener, MouseListener {

	private AgendaModel model;
	private ActivityBankPanel view;

	public ActivityBankController(AgendaModel model) {
		this.model = model;
		this.view = new ActivityBankPanel(model);

		// attach listeners to "Add Activity" - Button
		view.getBtnAddActivity().addActionListener(this);
		view.getListActivities().addMouseListener(this);
		// TODO: perhaps add some possibility to change a given activity?

		// controller displays the view
		// TODO: add to main view not to new Frame
		JFrame frame = new JFrame("Activities");		
		frame.add(view);
		frame.setVisible(true);

		// XXX:controller close view when the window is closed?
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// controller pops up EditActivityFrame-view
		// EditActivityController editViewController = new EditActivityController(model, new EditActivityFrame());
		System.out.println("Hi");
		model.addParkedActivity(new Activity("hi", "If I see this text, everything works and I'm soooo happy!", 2, 1));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JList list = (JList)e.getSource();
        if (e.getClickCount() == 2) {
            int index = list.locationToIndex(e.getPoint());
            Activity selectedActivity = view.getListActivities().getElementAtIndex(index);
            // Open up EditActivityController with selected Activity
            System.out.println("open up");
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

	

}
