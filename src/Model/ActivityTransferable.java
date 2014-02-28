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

    public ActivityTransferable(Activity activity) {
        this.activity = activity;
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
            return activity;
        }
        return null;
    }


}
