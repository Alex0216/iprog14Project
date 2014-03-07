package Model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.Arrays;

/**
 * Created by Alexandre on 28/02/14.
 * Project: Project.Model.${FILE_NAME}
 */
public class ActivityTransferable implements Transferable {

    Activity activity;
    Day from;
    int position;

    public ActivityTransferable(Activity activity, Day from, int position) {
        this.activity = activity;
        this.from = from;
        this.position = position;
    }

    public static DataFlavor[] supported = {new DataFlavor(Activity.class, "ActivityFlavor")};

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return supported;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return Arrays.asList(supported).contains(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) {
        if (isDataFlavorSupported(flavor)) {
            return this;
        }
        return null;
    }

    public Day getDayFrom() {
        return from;
    }

    public int getPosition() {
        return position;
    }

    public Activity getActivity() {
        return activity;
    }
}
