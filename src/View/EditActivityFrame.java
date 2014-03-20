package View;

import Model.Activity;

import javax.swing.*;
import java.awt.*;

/**
 * Created by group11 on 25/02/14. This is the view to create or modified an
 * activity as shown on page 3 of the powerpoint presentation. It can be use to
 * either create a new activity or to edit an existing one Edited by Jingxiang
 * Gou 01/03/14, for items in JCombobox.
 */
public class EditActivityFrame extends JFrame {

    private JTextField txtActivityName;
    private JSpinner spinnerDuration;
    private JComboBox comboTypeActivity;
    private JEditorPane descriptionPane;
    private JButton btnSave;
    private JButton btnCancel;

    // Specifies whether we edit or create an activity
    // TODO: Here or in controller?
    private int flag;

    public static final int EDIT = 0;
    public static final int NEW = 1;
    private JLabel lblErrorName;

    /*
     * Create an EditActivityFrame for creating a new Activity
     */
    public EditActivityFrame() {
        createGui();
        flag = NEW;
    }

    public EditActivityFrame(Activity activity) {
        createGui();
        flag = EDIT;
        txtActivityName.setText(activity.getName());
        spinnerDuration.setValue(activity.getLength());
        comboTypeActivity.setSelectedIndex(activity.getType());
        descriptionPane.setText(activity.getDescription());

    }

    private void createGui() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{30, 0, 30, 0, 0, 30};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        Component verticalStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
        gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
        gbc_verticalStrut.gridx = 3;
        gbc_verticalStrut.gridy = 0;
        getContentPane().add(verticalStrut, gbc_verticalStrut);

        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 1;
        getContentPane().add(lblName, gbc_lblName);

        lblErrorName = new JLabel("");
        lblErrorName.setForeground(Color.RED);
        GridBagConstraints gbc_lblErrorName = new GridBagConstraints();
        gbc_lblErrorName.anchor = GridBagConstraints.EAST;
        gbc_lblErrorName.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorName.gridx = 4;
        gbc_lblErrorName.gridy = 1;
        getContentPane().add(lblErrorName, gbc_lblErrorName);

        txtActivityName = new JTextField();
        lblName.setLabelFor(txtActivityName);
        GridBagConstraints gbc_txtActivityName = new GridBagConstraints();
        gbc_txtActivityName.gridwidth = 4;
        gbc_txtActivityName.insets = new Insets(0, 0, 5, 5);
        gbc_txtActivityName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtActivityName.gridx = 1;
        gbc_txtActivityName.gridy = 2;
        getContentPane().add(txtActivityName, gbc_txtActivityName);
        txtActivityName.setColumns(40);

        Component verticalStrut_1 = Box.createVerticalStrut(10);
        GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
        gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
        gbc_verticalStrut_1.gridx = 1;
        gbc_verticalStrut_1.gridy = 3;
        getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);

        JLabel lblLength = new JLabel("Length");
        GridBagConstraints gbc_lblLength = new GridBagConstraints();
        gbc_lblLength.anchor = GridBagConstraints.WEST;
        gbc_lblLength.insets = new Insets(0, 0, 5, 5);
        gbc_lblLength.gridx = 1;
        gbc_lblLength.gridy = 4;
        getContentPane().add(lblLength, gbc_lblLength);

        spinnerDuration = new JSpinner();
        lblLength.setLabelFor(spinnerDuration);
        spinnerDuration.setModel(new SpinnerNumberModel(0, 0, 999, 1));
        GridBagConstraints gbc_txtFieldDuration = new GridBagConstraints();
        gbc_txtFieldDuration.gridwidth = 2;
        gbc_txtFieldDuration.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldDuration.insets = new Insets(0, 0, 5, 5);
        gbc_txtFieldDuration.gridx = 1;
        gbc_txtFieldDuration.gridy = 5;
        getContentPane().add(spinnerDuration, gbc_txtFieldDuration);

        JLabel lblMin = new JLabel("min");
        lblMin.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblMin = new GridBagConstraints();
        gbc_lblMin.insets = new Insets(0, 0, 5, 5);
        gbc_lblMin.anchor = GridBagConstraints.WEST;
        gbc_lblMin.gridx = 3;
        gbc_lblMin.gridy = 5;
        getContentPane().add(lblMin, gbc_lblMin);

        Component verticalStrut_3 = Box.createVerticalStrut(10);
        GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
        gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
        gbc_verticalStrut_3.gridx = 1;
        gbc_verticalStrut_3.gridy = 6;
        getContentPane().add(verticalStrut_3, gbc_verticalStrut_3);

        comboTypeActivity = new JComboBox();
        GridBagConstraints gbc_comboTypeActivity = new GridBagConstraints();
        gbc_comboTypeActivity.gridwidth = 4;
        gbc_comboTypeActivity.insets = new Insets(0, 0, 5, 5);
        gbc_comboTypeActivity.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboTypeActivity.gridx = 1;
        gbc_comboTypeActivity.gridy = 7;
        getContentPane().add(comboTypeActivity, gbc_comboTypeActivity);

        // TODO add items for the dropbox -> done?!
        comboTypeActivity.addItem("Presentation");
        comboTypeActivity.addItem("Group Work");
        comboTypeActivity.addItem("Discussion");
        comboTypeActivity.addItem("Break");

        Component verticalStrut_2 = Box.createVerticalStrut(10);
        GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
        gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
        gbc_verticalStrut_2.gridx = 1;
        gbc_verticalStrut_2.gridy = 8;
        getContentPane().add(verticalStrut_2, gbc_verticalStrut_2);

        JLabel lblDescription = new JLabel("Description");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.anchor = GridBagConstraints.WEST;
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 1;
        gbc_lblDescription.gridy = 9;
        getContentPane().add(lblDescription, gbc_lblDescription);

        descriptionPane = new JEditorPane();
        lblDescription.setLabelFor(descriptionPane);
        descriptionPane.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints gbc_descriptionPane = new GridBagConstraints();
        gbc_descriptionPane.insets = new Insets(0, 0, 5, 5);
        gbc_descriptionPane.gridwidth = 4;
        gbc_descriptionPane.fill = GridBagConstraints.BOTH;
        gbc_descriptionPane.gridx = 1;
        gbc_descriptionPane.gridy = 10;
        getContentPane().add(descriptionPane, gbc_descriptionPane);

        btnCancel = new JButton("Cancel");
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCancel.weightx = 1.0;
        gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
        gbc_btnCancel.gridx = 3;
        gbc_btnCancel.gridy = 11;
        getContentPane().add(btnCancel, gbc_btnCancel);

        btnSave = new JButton("Save");
        GridBagConstraints gbc_btnSave = new GridBagConstraints();
        gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnSave.weightx = 1.0;
        gbc_btnSave.insets = new Insets(0, 0, 5, 5);
        gbc_btnSave.gridx = 4;
        gbc_btnSave.gridy = 11;
        getContentPane().add(btnSave, gbc_btnSave);
    }

    public int getFlag() {
        return flag;
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

    public JSpinner getSpinnerDuration() {
        return spinnerDuration;
    }

    public JTextField getTxtActivityName() {
        return txtActivityName;
    }

    public JLabel getLblErrorName() {
        return lblErrorName;
    }

    public void setActivityType(int index) {
        String type = (String) this.comboTypeActivity.getItemAt(index);
        this.comboTypeActivity.getModel().setSelectedItem(type);
    }

    public void setActivityName(String name) {
        this.txtActivityName.setText(name);
    }

    public void setDuration(int length) {
        this.spinnerDuration.setValue(length);
    }

    public void setDescription(String lblDescription) {
        this.descriptionPane.setText(lblDescription);
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


}
