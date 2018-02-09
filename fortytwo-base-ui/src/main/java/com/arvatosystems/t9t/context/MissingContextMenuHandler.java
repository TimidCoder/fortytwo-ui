package com.arvatosystems.t9t.context;

import org.zkoss.zul.Messagebox;

import com.arvatosystems.t9t.components.Grid28;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Any;
import de.jpaw.dp.Fallback;
import de.jpaw.dp.Singleton;

@Singleton
@Fallback
@Any
public class MissingContextMenuHandler implements IGridContextMenu<BonaPortable> {

    @Override
    public void selected(Grid28 lb, DataWithTracking<BonaPortable, TrackingBase> dwt) {
        Messagebox.show("Not available", "Error", Messagebox.CANCEL, Messagebox.EXCLAMATION);
    }
}
