package View;

import Model.Activity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Alexandre on 27/02/14.
 * Project: Project.View.${FILE_NAME}
 */
public class ActivityJList extends JList<Activity> {


    public ActivityJList(List<Activity> activities) {
        super();

        setForeground(new Color(0, 0, 0));
        setBorder(BorderFactory.createDashedBorder(Color.black, 8, 4));
        setBackground(new Color(255, 255, 255));

        setFixedCellHeight(50);
        setFixedCellWidth(100);


        DefaultListModel<Activity> listModel = new DefaultListModel<Activity>();
        for (Activity a : activities)
            listModel.addElement(a);
        setModel(listModel);

    }

}
