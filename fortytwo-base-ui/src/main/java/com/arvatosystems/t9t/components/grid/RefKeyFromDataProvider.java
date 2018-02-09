package com.arvatosystems.t9t.components.grid;

import de.jpaw.bonaparte.pojos.api.LongFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.bonaparte.pojos.apiw.Ref;
import de.jpaw.dp.Any;
import de.jpaw.dp.Fallback;
import de.jpaw.dp.Singleton;

/** The default implementation (which is valid for most viewModels) implements the SurrogateKey filter. */
@Singleton
@Any
@Fallback
public class RefKeyFromDataProvider implements IKeyFromDataProvider<Ref, TrackingBase> {

    @Override
    public SearchFilter getFilterForKey(DataWithTracking<Ref, TrackingBase> dwt) {
        Long objectRef = dwt.getData().getObjectRef();
        final LongFilter byId = new LongFilter("objectRef");
        byId.setEqualsValue(objectRef);
        return byId;
    }
}
