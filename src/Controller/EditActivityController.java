package Controller;

import Model.Activity;
import Model.AgendaModel;
import View.EditActivityFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Alexandre on 25/02/14.
 *  Edited and fullfill the model by Jingxiang Gou on 28/02/14. Reviewed by Zhu & Gou
 */
public class EditActivityController implements ActionListener {


    private AgendaModel model;
	private EditActivityFrame view;

    private Activity editActivity = null;

    public EditActivityController(AgendaModel model) {

    	this.model = model;
    	this.view = new EditActivityFrame();

        this.view.getBtnCancel().addActionListener(this);
        this.view.getBtnSave().addActionListener(this);

    }

    public EditActivityController(AgendaModel model, EditActivityFrame view, Activity editActivity) {
        this(model);
        this.editActivity = editActivity;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Just close the window
        if (e.getSource().equals(this.view.getBtnCancel()))
            view.dispose();
        if (e.getSource().equals(this.view.getBtnSave())) {
            String name = view.getTxtActivityName().getText();
            int length = (Integer) view.getSpinnerDuration().getValue();
            int type = view.getComboTypeActivity().getSelectedIndex();
            String description = view.getDescriptionPane().getText();

            if (name.isEmpty()) {
                view.getLblErrorName().setText("Name cannot be blank!");
                return;
            }

            if (view.getFlag() == EditActivityFrame.NEW) {
                Activity newActivity = new Activity(name, description, length, type);
                model.addParkedActivity(newActivity);
            } else if (view.getFlag() == EditActivityFrame.EDIT) {
                editActivity.setName(name);
                editActivity.setDescription(description);
                editActivity.setLength(length);
                editActivity.setType(type);
            }
        }

    }
}
