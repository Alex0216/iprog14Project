package Controller;

import Model.AgendaModel;
import View.DayPanel;

/**
 * Created by Alexandre on 25/02/14.
 */
public class DayPanelController {

    AgendaModel model;
    DayPanel view;

    public DayPanelController(AgendaModel model, DayPanel view) {
        this.model = model;
        this.view = view;
    }
}
