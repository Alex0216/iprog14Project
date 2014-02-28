package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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

    public MainView() {
    	
    	JPanel activityPanel = new ActivityBankPanel();
    	getContentPane().add(activityPanel, BorderLayout.WEST);
    	
    	JScrollPane dayScrollPane = new JScrollPane();
    	getContentPane().add(dayScrollPane, BorderLayout.CENTER);
    	
    	JPanel daysPanel = new JPanel();
    	dayScrollPane.setViewportView(daysPanel);
    	
    	JPanel defaultDayPanel = new DayPanel();
    	FlowLayout flowLayout = (FlowLayout) defaultDayPanel.getLayout();
    	flowLayout.setAlignOnBaseline(true);
    	daysPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
    	daysPanel.add(defaultDayPanel);
    	
    	JButton btnAddDay = new JButton("+ Add New Day");
    	daysPanel.add(btnAddDay);

    }
}
