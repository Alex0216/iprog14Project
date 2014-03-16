package View;

import Model.Day;

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
        this.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

    }

    public DayPanel addDayPanel(Day day) {
        DayPanel dayPanel = new DayPanel(day);

        add(dayPanel);
        this.updateUI();
		
		this.dayPanelList.add(dayPanel);
		return dayPanel;
	}

}
