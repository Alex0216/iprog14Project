package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yeonni on 02/03/14.
 */
public class DaysPanel extends JPanel {
	public List<DayPanel> dayPanelList;
		
	public DaysPanel() {
		this.dayPanelList = new ArrayList<DayPanel>();

        setLayout(new GridLayout(1, 10, 10, 10));

	}
	
	public DayPanel addDayPanel() {
		DayPanel dayPanel = new DayPanel();

        add(dayPanel);
        this.updateUI();
		
		this.dayPanelList.add(dayPanel);
		return dayPanel;
	}

}
