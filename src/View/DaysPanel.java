package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Created by Yeonni on 02/03/14.
 */
public class DaysPanel extends JPanel {
	public List<DayPanel> dayPanelList;
		
	public DaysPanel() {
		this.dayPanelList = new ArrayList<DayPanel>();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

	}
	
	public DayPanel addDayPanel() {
		DayPanel dayPanel = new DayPanel();
		dayPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_dayPanel = new GridBagConstraints();
		gbc_dayPanel.anchor = GridBagConstraints.NORTH;
		add(dayPanel, gbc_dayPanel);
		this.updateUI();
		
		this.dayPanelList.add(dayPanel);
		return dayPanel;
	}

}
