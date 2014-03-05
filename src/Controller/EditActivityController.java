package Controller;

import Model.Activity;
import Model.AgendaModel;
import View.EditActivityFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexandre on 25/02/14. Edited and fullfill the model by Jingxiang
 * Gou on 28/02/14. Reviewed by Zhu & Gou
 */
public class EditActivityController implements ActionListener {

	private AgendaModel model;
	private EditActivityFrame view;

	private Activity editActivity = null;

	public EditActivityController(AgendaModel model) {
		this.model = model;
		this.view = new EditActivityFrame();
		view.setSize(400, 600);
		view.setVisible(true);
		
		this.view.setFlag(EditActivityFrame.NEW);

		this.view.getBtnCancel().addActionListener(this);
		this.view.getBtnSave().addActionListener(this);

	}

	// Sets editingMode to true!!!
	public EditActivityController(AgendaModel model, Activity editActivity) {
		this(model);
		this.editActivity = editActivity;
		this.view.setFlag(EditActivityFrame.EDIT);
		
		this.view.setActivityName(this.editActivity.getName());
		this.view.setDuration(this.editActivity.getLength());
		this.view.setDescription(this.editActivity.getDescription());
		this.view.setActivityType(this.editActivity.getType());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Just close the window
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

			view.dispose();
		}

	}
}
