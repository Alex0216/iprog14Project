package View;

import Model.Activity;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexandre on 27/02/14.
 * Project: Project.View.${FILE_NAME}
 */
public class ActivityJList extends JList {


    public ActivityJList() {
        super();

        setForeground(new Color(255, 255, 255));
        setBorder(BorderFactory.createDashedBorder(Color.black, 8, 4));
        setBackground(new Color(255, 255, 255));

        setFixedCellHeight(50);
        setFixedCellWidth(100);


        DefaultListModel<Activity> listModel = new DefaultListModel<Activity>();
        setModel(listModel);

    }


}
