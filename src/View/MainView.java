package View;

import Model.AgendaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

    public MainView(AgendaModel model) {

        activityPanel = new ActivityBankPanel(model);
        activityPanel.setPreferredSize(new Dimension(300, 500));
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
