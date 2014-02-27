package View;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.List;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

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
		
		listActivities = new JList();
		listActivities.setForeground(new Color(0, 0, 0));
		listActivities.setBorder(BorderFactory.createDashedBorder(listActivities.getForeground(), 8, 4));
		listActivities.setBackground(new Color(255, 255, 255));
		add(listActivities, BorderLayout.CENTER);
		
		btnAddActivity = new JButton("+Add activity");
		btnAddActivity.setForeground(new Color(0, 0, 0));
		btnAddActivity.setBackground(new Color(0, 0, 0));
		add(btnAddActivity, BorderLayout.NORTH);

	}

	public JList getListActivities() {
		return listActivities;
	}
	public JButton getBtnAddActivity() {
		return btnAddActivity;
	}
}
