package com.arvatosystems.t9t.components.grid;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;

public interface IKeyFromDataProvider<DTO extends BonaPortable, TRACKING extends TrackingBase> {
    /** Given an object with tracking, return a suitable search filter which selects the unique record
     * which was given as the input (search by primary key).
     * @param dwt
     * @return
     */
    SearchFilter getFilterForKey(DataWithTracking<DTO, TRACKING> dwt);
}
