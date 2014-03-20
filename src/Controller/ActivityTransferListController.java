package Controller;

import Model.Activity;
import Model.ActivityTransferable;
import Model.AgendaModel;
import Model.Day;
import View.ActivityJList;

import javax.swing.*;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created by Alexandre on 28/02/14.
 * Project: Project.Controller.${FILE_NAME}
 */
public class ActivityTransferListController extends TransferHandler {
    int selected;
    Day from;
    AgendaModel model;
    Activity dragged;
    private ActivityJList list;

    // ---------------- SOURCE methods

    public ActivityTransferListController(ActivityJList list, Day from, AgendaModel model) {
        this.list = list;
        this.from = from;
        this.model = model;
        list.setDragEnabled(true);
        list.setDropMode(DropMode.INSERT);
        list.setTransferHandler(this);
    }

    /**
     * data transfer semantic
     */
    @Override
    public int getSourceActions(JComponent source) {

        return TransferHandler.MOVE;
    }

    /**
     * Create a transferable with the activity
     */
    @Override
    public ActivityTransferable createTransferable(JComponent source) {
        selected = list.getSelectedIndex();
        dragged = (Activity) list.getSelectedValue();
        return new ActivityTransferable(dragged, from, list.getSelectedIndex());
    }

    /**
     * remove the dragged element once it was transferred somewhere else
     */
    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
        //Nothing to do here because of the Observer pattern!
    }

    // ---------------- TARGET methods

    /**
     * called during drag over, to see whether we can accept a drop
     */
    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        return support.isDataFlavorSupported(ActivityTransferable.supported[0]);
    }

    /**
     * Drop or paste took place
     */
    @Override
    public boolean importData(TransferHandler.TransferSupport supp) {
        if (!canImport(supp)) {
            return false;
        }
        if (!supp.isDrop())
            return false;

        Transferable t = supp.getTransferable();


        ActivityTransferable data = null;
        try {
            data = (ActivityTransferable) t.getTransferData(ActivityTransferable.supported[0]);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fetch the drop location
        JList.DropLocation loc = (JList.DropLocation) supp.getDropLocation();
        // Insert the data at this location
        ((DefaultListModel) list.getModel()).add(loc.getIndex(), data.getActivity());
        model.moveActivity(data.getDayFrom(), data.getPosition(), from, loc.getIndex());

        return true;

    }

}
