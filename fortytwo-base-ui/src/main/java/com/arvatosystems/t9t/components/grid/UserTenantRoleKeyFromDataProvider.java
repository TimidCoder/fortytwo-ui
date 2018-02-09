package com.arvatosystems.t9t.components.grid;

import com.arvatosystems.t9t.auth.UserTenantRoleDTO;
import com.arvatosystems.t9t.base.T9tConstants;

import de.jpaw.bonaparte.api.SearchFilters;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.bonaparte.pojos.api.LongFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.apiw.DataWithTrackingW;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("userTenantRole")
public class UserTenantRoleKeyFromDataProvider implements IKeyFromDataProvider<UserTenantRoleDTO, TrackingBase> {

    @Override
    public SearchFilter getFilterForKey(DataWithTracking<UserTenantRoleDTO, TrackingBase> dwt) {
        final LongFilter tenantFilter = new LongFilter(T9tConstants.TENANT_REF_FIELD_NAME42);
        tenantFilter.setEqualsValue(((DataWithTrackingW<UserTenantRoleDTO, TrackingBase>)dwt).getTenantRef());

        final LongFilter roleFilter = new LongFilter("roleRef");
        roleFilter.setEqualsValue(dwt.getData().getRoleRef().getObjectRef());

        final LongFilter userFilter = new LongFilter("userRef");
        userFilter.setEqualsValue(dwt.getData().getUserRef().getObjectRef());

        return SearchFilters.and(tenantFilter, SearchFilters.and(roleFilter, userFilter));
    }
}
