package View;

import Model.Activity;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Button;

/**
 * Created by group11 on 25/02/14.
 * This is the view to create or modified an activity as shown on page 3 of the
 * powerpoint presentation. It can be use to either create a new activity or to
 * edit an existing one
 * Edited by Jingxiang Gou 01/03/14, for items in JCombobox.
 */
public class EditActivityFrame extends JFrame {
	
	private JTextField txtActivityName;
	private JFormattedTextField txtFieldDuration;
	private JComboBox comboTypeActivity;
	private JEditorPane descriptionPane;
	private JButton btnSave;
	private JButton btnCancel;

    /*
    Create an EditActivityFrame for creating a new Activity
     */
    public EditActivityFrame() {
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[] {30, 0, 30, 0, 0, 30};
    	gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
    	getContentPane().setLayout(gridBagLayout);
    	
    	txtActivityName = new JTextField();
    	txtActivityName.setText("Introduction");
    	GridBagConstraints gbc_txtActivityName = new GridBagConstraints();
    	gbc_txtActivityName.gridwidth = 4;
    	gbc_txtActivityName.insets = new Insets(0, 0, 5, 5);
    	gbc_txtActivityName.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtActivityName.gridx = 1;
    	gbc_txtActivityName.gridy = 1;
    	getContentPane().add(txtActivityName, gbc_txtActivityName);
    	txtActivityName.setColumns(40);
    	
    	txtFieldDuration = new JFormattedTextField();
    	GridBagConstraints gbc_txtFieldDuration = new GridBagConstraints();
    	gbc_txtFieldDuration.gridwidth = 2;
    	gbc_txtFieldDuration.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtFieldDuration.insets = new Insets(0, 0, 5, 5);
    	gbc_txtFieldDuration.gridx = 1;
    	gbc_txtFieldDuration.gridy = 2;
    	getContentPane().add(txtFieldDuration, gbc_txtFieldDuration);
    	txtFieldDuration.setColumns(4);
    	
    	JLabel lblMin = new JLabel("min");
    	lblMin.setHorizontalAlignment(SwingConstants.LEFT);
    	GridBagConstraints gbc_lblMin = new GridBagConstraints();
    	gbc_lblMin.insets = new Insets(0, 0, 5, 5);
    	gbc_lblMin.anchor = GridBagConstraints.WEST;
    	gbc_lblMin.gridx = 3;
    	gbc_lblMin.gridy = 2;
    	getContentPane().add(lblMin, gbc_lblMin);
    	
    	comboTypeActivity = new JComboBox();
    	GridBagConstraints gbc_comboTypeActivity = new GridBagConstraints();
    	gbc_comboTypeActivity.gridwidth = 4;
    	gbc_comboTypeActivity.insets = new Insets(0, 0, 5, 5);
    	gbc_comboTypeActivity.fill = GridBagConstraints.HORIZONTAL;
    	gbc_comboTypeActivity.gridx = 1;
    	gbc_comboTypeActivity.gridy = 3;
    	getContentPane().add(comboTypeActivity, gbc_comboTypeActivity);
    	
        // TODO add items for the dropbox
    	comboTypeActivity.addItem("1");
    	comboTypeActivity.addItem("2");
    	comboTypeActivity.addItem("3");
    	comboTypeActivity.addItem("4");

        
    	descriptionPane = new JEditorPane();
    	descriptionPane.setBorder(BorderFactory.createLineBorder(Color.black));
    	GridBagConstraints gbc_descriptionPane = new GridBagConstraints();
    	gbc_descriptionPane.insets = new Insets(0, 0, 5, 5);
    	gbc_descriptionPane.gridwidth = 4;
    	gbc_descriptionPane.fill = GridBagConstraints.BOTH;
    	gbc_descriptionPane.gridx = 1;
    	gbc_descriptionPane.gridy = 4;
    	getContentPane().add(descriptionPane, gbc_descriptionPane);
    	
    	btnCancel = new JButton("Cancel");
    	GridBagConstraints gbc_btnCancel = new GridBagConstraints();
    	gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
    	gbc_btnCancel.weightx = 1.0;
    	gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
    	gbc_btnCancel.gridx = 3;
    	gbc_btnCancel.gridy = 5;
    	getContentPane().add(btnCancel, gbc_btnCancel);
    	
    	btnSave = new JButton("Save");
    	GridBagConstraints gbc_btnSave = new GridBagConstraints();
    	gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
    	gbc_btnSave.weightx = 1.0;
    	gbc_btnSave.insets = new Insets(0, 0, 5, 5);
    	gbc_btnSave.gridx = 4;
    	gbc_btnSave.gridy = 5;
    	getContentPane().add(btnSave, gbc_btnSave);

    }

    /*
    Create an EditActivityFrame to edit an existing Activity
     */
    public EditActivityFrame(Activity activity) {

    }
	public JButton getBtnSave() {
		return btnSave;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public JEditorPane getDescriptionPane() {
		return descriptionPane;
	}
	public JComboBox getComboTypeActivity() {
		return comboTypeActivity;
	}
	public JFormattedTextField getTxtFieldDuration() {
		return txtFieldDuration;
	}
	public JTextField getTxtActivityName() {
		return txtActivityName;
	}
}
