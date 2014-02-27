package View;

import Model.Activity;

import javax.swing.*;
import java.awt.*;

/**
 * Created by group11 on 25/02/14.
 * This the view representing an activity that is draggable. It shows the name
 * of the activity, the duration or the start time of the activity depending
 * where the view is. The view also has a color corresponding to the activity.
 * Clicking an activity should bring the EditActivityFrame
 */
public class ActivityCellRenderer extends JPanel implements ListCellRenderer {

    private JLabel lblTime;
	private JLabel lblName;

    public ActivityCellRenderer() {
        setLayout(new BorderLayout(10, 10));

        lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
        lblTime.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
        Activity activity = (Activity) value;
        lblTime.setText(String.valueOf(activity.getLength()) + " min");
        lblName.setText(activity.getName());


        switch (activity.getType()) {
            case Activity.BREAK:
                setBackground(new Color(255, 255, 0));
                break;
            case Activity.PRESENTATION:
                setBackground(new Color(198, 217, 241));
                break;
            case Activity.DISCUSSION:
                setBackground(new Color(195, 214, 155));
                break;
            case Activity.GROUP_WORK:
                setBackground(new Color(253, 234, 218));
                break;
            default:
                setBackground(list.getBackground());
                setForeground(list.getForeground());
        }
        if (isSelected) {
            setBorder(BorderFactory.createLineBorder(Color.BLACK));

        } else {
            setBorder(BorderFactory.createEmptyBorder());
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;

    }

    public JLabel getLblTime() {
		return lblTime;
	}
	public JLabel getLblName() {
		return lblName;
	}
}
