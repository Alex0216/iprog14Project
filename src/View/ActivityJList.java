package View;

import Model.Activity;

import javax.swing.*;

import java.awt.*;
import java.util.List;

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
        //ActivityListModel listModel = new ActivityListModel(data);
        setModel(listModel);

    }


        list.add(new Activity("Introduction", "Intro to the meeting", 10, 0));
        list.add(new Activity("Idea 1", "Presenting idea 1", 30, 0));
        list.add(new Activity("Working in groups", "Working on business model for idea 1", 35, 1));
        list.add(new Activity("Idea 1 discussion", "Discussing the results of idea 1", 15, 2));
        list.add(new Activity("Coffee break", "Time for some coffee", 20, 3));

        return list;
    }
    
    public void addActivity(Activity activity){
    	ActivityListModel activityListModel = (ActivityListModel) getModel();
    	ArrayList<Activity> storedActivities = activityListModel.getActivities();
    	storedActivities.add(activity);
    	setModel(activityListModel);
    }
    
    public void addAllActivities(List<Activity> activities){
    	for(Activity activity : activities){
    		this.addActivity(activity);
    	}
    }
    
    public Activity getElementAtIndex(int index){
    	ActivityListModel activityListModel = (ActivityListModel) getModel();
    	return (Activity) activityListModel.getElementAt(index);
    }


    class ActivityListModel extends AbstractListModel {
        private ArrayList<Activity> activities;

        public ActivityListModel(ArrayList<Activity> activities) {
            this.activities = activities;
        }
        
        protected ArrayList<Activity> getActivities(){
        	return this.activities;
        }

        @Override
        public int getSize() {
            return activities.size();
        }

        @Override
        public Object getElementAt(int index) {
            return activities.get(index);
        }
    }
}
