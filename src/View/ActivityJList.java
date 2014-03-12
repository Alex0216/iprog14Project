package View;

import Model.Activity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * Created by Alexandre on 27/02/14.
 * Project: Project.View.${FILE_NAME}
 */
public class ActivityJList extends JList<Activity> implements MouseMotionListener {


    public ActivityJList(List<Activity> activities) {
        super();

        setForeground(new Color(0, 0, 0));
        setBorder(BorderFactory.createDashedBorder(Color.black, 8, 4));
        setBackground(new Color(255, 255, 255));

        setFixedCellHeight(50);
        setFixedCellWidth(100);

        this.addMouseMotionListener(this);
        DefaultListModel<Activity> listModel = new DefaultListModel<Activity>();
        for (Activity a : activities)
            listModel.addElement(a);
        setModel(listModel);

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        // only display a hand if the cursor is over the items
        final Rectangle cellBounds = this.getCellBounds(0, this.getModel().getSize() - 1);
        if (cellBounds != null && cellBounds.contains(x, y)) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
