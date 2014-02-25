package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by group11 on 25/02/14.
 * This the view representing an activity that is draggable. It shows the name
 * of the activity, the duration or the start time of the activity depending
 * where the view is. The view also has a color corresponding to the activity.
 * Clicking an activity should bring the EditActivityFrame
 * <p/>
 * NOTE: I'm not sure about the JLable, but I think it will be simpler like
 * that
 */
public class ActivityLabel extends JLabel implements ListCellRenderer {


    /*
    This is the method we have to override the customize how the activity will
    look like in a JList
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        return null;
    }
}
