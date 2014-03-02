package Controller;

import Model.AgendaModel;
import Model.Activity;
import View.EditActivityFrame;
import java.awt.event.*;

import javax.swing.*;


/**
 * Created by Alexandre on 25/02/14.
 *  Edited and fullfill the model by Jingxiang Gou on 28/02/14. Reviewed by Zhu & Gou
 */
public class EditActivityController {
    
	/*private JTextField txtActivityname;
	private JFormattedTextField txtFielduration;
	private JComboBox comboTypeactivity;
	private JEditorPane descriptionpane;
	*/
	private AgendaModel model;
	private EditActivityFrame view;
	
	
    public EditActivityController(AgendaModel model, EditActivityFrame view) {
    	
    	this.model = model;
    	this.view = view;
		addEventsListener(); // seperated the Listener into another class 

     } // inner EditActivityController(...,...)

    
	private void addEventsListener()
	{
		// add key listener for duration
		final JFormattedTextField durationField = view.getTxtFieldDuration();
		durationField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				// TODO Auto-generated method stub
		    /* Add the CONSTRAINT for the time duration field to make it digits-input-only */
//				if (e.getKeyCode() == KeyEvent.VK_ENTER)
//				{
					char[] text = durationField.getText().toCharArray();
					for (char ch : text)
					{
						if (!Character.isDigit(ch))
						{
							JOptionPane.showMessageDialog(view,
									"Please Input Only Digital Characters :)!", "Warning",
									JOptionPane.WARNING_MESSAGE);
							durationField.setText("");
							return;
						}
					}
				}
//			}
		});

		// add cancel button listener
		JButton cancelBtn = view.getBtnCancel();
		cancelBtn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO WHETHER Just exit for the whole page  ？？
			    // int value = JOptionPane.showConfirmDialog(null, "Are you sure to cancel？");
	            //  if（value == JOPtionPane.OK_OPTION）{
				System.exit(0);
	         // }
			}
		});

		// add save button listener
		JButton saveBtn = view.getBtnSave();
		saveBtn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				saveActivity(); // seperated in an other class 
			}
		});

	}   
 
    	
    	// btnSave, save the selection on mouse button events
    	JButton btnsave = new JButton(editactivityview.getBtnSave());
    	btnsave.addActionListener(savevent);                                
    	
    	
    	public void saveActivity()
    	{
    		// get elements content for Activity
    		JTextField actNameField = view.getTxtActivityName();
    		String name = actNameField.getText();
    		
    		JFormattedTextField durationField = view.getTxtFieldDuration();
    		String durString = durationField.getText();
    		
    		JComboBox box = view.getComboTypeActivity();
    		String typeString = box.getSelectedItem().toString();
    		
    		JEditorPane desptPane = view.getDescriptionPane();
    		String description = desptPane.getText();
    		
    		int length;
    		int type;
    		try
    		{
    			length = Integer.valueOf(durString);
    			type = Integer.valueOf(typeString);
    		} catch (Exception e)
    		{
    			// TODO hint for dealing with Exception, Popup?

    			return;
    		}
    		// TODO check for 
    		if (length < 0)
    		{
    			System.out.println("length can not be smaller than 0!");
    			return;
    		}
    		
    		Activity newActivity = new Activity(name, description, length, type);
    		model.addParkedActivity(newActivity);
    		System.out.println("save success");
    	}  // end saveActivity

    	// showView method for calling in Mainpage 
    	public void showView()
    	{
    		view.setVisible(true);
    	} 
    	
    	
    	//finalize the content 
        setChanged();
        notifyObservers();
           
            
}// outer EditActivityController



// Codes not used 
/*
 *         class SaveEventsListener implements ActionListener { 
        	
            public void actionPerformed(MouseEvent event) {
                int i = event.getButton();
                if (i == MouseEvent.BUTTON1)
                    System.out.print("Saved");        
                
                String name = txtactivityname.toString();
                String description = descriptionpane.toString();
                int length = Integer.parseInt(txtFielduration.toString());
                
                /*
                // Handle exceptions
                try {
                	length = Integer.parseInt(txtFielduration.toString());
                } catch (Exception e) {
					// TODO: handle exceptionlog                	
                	return;
				}
				*/
/*
                
                int type =  Integer.parseInt(comboTypeactivity.getType());
                
                // need to SAVE all the details in edit page, create a new act and add it to mainpage
                Activity newActivity = new Activity(name, desription, length, type);  
                
            	if (null != newActivity){
                	amodel.addParkedActivity(newActivity);//save states to the Amodel,shown in the calendar 
                	}
                
            }
        } // SaveEventsListener
        
        */
