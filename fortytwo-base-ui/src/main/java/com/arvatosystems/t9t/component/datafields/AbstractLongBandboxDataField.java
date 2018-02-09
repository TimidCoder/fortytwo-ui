package com.arvatosystems.t9t.component.datafields;

import com.arvatosystems.t9t.base.crud.RefResolverRequest;
import com.arvatosystems.t9t.base.crud.RefResolverResponse;
import com.arvatosystems.t9t.component.ext.EventDataSelect28;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.bonaparte.pojos.apiw.Ref;

public abstract class AbstractLongBandboxDataField extends AbstractBandboxDataField<Long> {
    protected AbstractLongBandboxDataField(DataFieldParameters params, String gridId) {
        super(params, gridId);
    }

    protected Long resolve(RefResolverRequest<?> rq) {
        RefResolverResponse res = remoteUtils.executeExpectOk(rq, RefResolverResponse.class);
        return res.getKey();
    }

    @Override
    public void setSelectionData(EventDataSelect28 eventData) {
        if (eventData == null || eventData.getDwt() == null) {
            clear();
        } else {
            DataWithTracking<BonaPortable, TrackingBase> dwt = eventData.getDwt();
            setValue(((Ref)dwt.getData()).getObjectRef());
        }
    }
}
