package com.arvatosystems.t9t.component.ext;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;

/** Data sent for onDataSelect event. */
public class EventDataSelect28 {
    public static final String ON_DATA_SELECT = "onDataSelect";  // the event name

    private final DataWithTracking<BonaPortable, TrackingBase> dwt;
    private final int keys;             // as used in onSelect event...
    private final String contextId;     // if fired by context menu (right click)

    public EventDataSelect28(DataWithTracking<BonaPortable, TrackingBase> dwt, int keys, String contextId) {
        this.dwt = dwt;
        this.keys = keys;
        this.contextId = contextId;
    }

    public String getContextId() {
        return contextId;
    }

    public int getKeys() {
        return keys;
    }

    public DataWithTracking<BonaPortable, TrackingBase> getDwt() {
        return dwt;
    }
}
