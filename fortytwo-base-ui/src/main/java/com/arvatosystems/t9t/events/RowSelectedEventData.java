package com.arvatosystems.t9t.events;

import de.jpaw.bonaparte.pojos.api.DataWithTracking;

/** Event structure sent by Grid28 when a row has been selected.
 * Can be processed by child grids to update detail views.
 */
public class RowSelectedEventData {
    String contextMenuId;             // if a context menu has been clicked, the ID of the menu entry
    Long key;                         // the key to the row, if the data has a surrogate key
    DataWithTracking<?,?> dwt;
}
