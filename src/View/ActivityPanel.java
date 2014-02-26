package View;

import javax.swing.*;
import java.awt.*;
import com.jgoodies.forms.factories.DefaultComponentFactory;

/**
 * Created by group11 on 25/02/14.
 * This the view representing an activity that is draggable. It shows the name
 * of the activity, the duration or the start time of the activity depending
 * where the view is. The view also has a color corresponding to the activity.
 * Clicking an activity should bring the EditActivityFrame
 */
public class ActivityPanel extends JPanel implements ListCellRenderer {
	
	private JLabel lblTime;
	private JLabel lblName;
	
	public ActivityPanel() {
		setLayout(new BorderLayout(0, 0));
		
		lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTime, BorderLayout.WEST);
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName, BorderLayout.CENTER);

	}

    /*
    This is the method we have to override the customize how the activity will
    look like in a JList
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        return null;
    }
    
	public JLabel getLblTime() {
		return lblTime;
	}
	public JLabel getLblName() {
		return lblName;
	}
}
