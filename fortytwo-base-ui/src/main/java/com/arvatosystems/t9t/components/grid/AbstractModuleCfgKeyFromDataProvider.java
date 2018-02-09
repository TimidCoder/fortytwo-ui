package com.arvatosystems.t9t.components.grid;

import com.arvatosystems.t9t.base.T9tConstants;
import com.arvatosystems.t9t.base.moduleCfg.ModuleConfigDTO;

import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.bonaparte.pojos.api.LongFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.apiw.DataWithTrackingW;

public abstract class AbstractModuleCfgKeyFromDataProvider<T extends ModuleConfigDTO> implements IKeyFromDataProvider<T, TrackingBase> {

    @Override
    public SearchFilter getFilterForKey(DataWithTracking<T, TrackingBase> dwt) {
        final LongFilter tenantFilter = new LongFilter();
        tenantFilter.setFieldName(T9tConstants.TENANT_REF_FIELD_NAME42);
        tenantFilter.setEqualsValue(((DataWithTrackingW<T, TrackingBase>)dwt).getTenantRef());
        return tenantFilter;
    }
}
