package Controller;

import Model.AgendaModel;
import View.ActivityBankPanel;

/**
 * Created by Alexandre on 25/02/14.
 */
public class ActivityBankController {


    public ActivityBankController(AgendaModel model, ActivityBankPanel view) {
        new ActivityTransferListController(view.getListActivities(), model);
    }
}
