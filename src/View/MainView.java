package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by Alexandre on 25/02/14.
 * This is the Main windows of the application. It contain an
 * ActivityBankPanel at the left, one or more DayPanel in the center with a
 * button to add more DayPanel if needed.
 * Project: ${PROJECT_NAME}.${PACKAGE_NAME}.${FILE_NAME}
 */
public class MainView extends JFrame {
	
	private JButton btnAddDay;
	private ActivityBankPanel activityPanel;
	private JScrollPane dayScrollPane;
	private DaysPanel daysPanel;
	
    public MainView() {
    	
    	activityPanel = new ActivityBankPanel();
    	getContentPane().add(activityPanel, BorderLayout.WEST);
    	
    	dayScrollPane = new JScrollPane();
    	getContentPane().add(dayScrollPane, BorderLayout.CENTER);
    	
    	daysPanel = new DaysPanel();
    	dayScrollPane.setViewportView(daysPanel);
    	
    	btnAddDay = new JButton("+ Add New Day");
    	dayScrollPane.setColumnHeaderView(btnAddDay);

    }
    
    public DaysPanel getDaysPanel() {
    	return daysPanel;
    }
    
    public ActivityBankPanel getActivityPanel() {
    	return activityPanel;
    }
    
    public boolean isBtnAddDay(Object obj) {
    	return obj == this.btnAddDay;
    }
    
    public void addBtnAddDayActionListener(ActionListener l) {
    	this.btnAddDay.addActionListener(l);
    }
}
