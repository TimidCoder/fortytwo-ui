package com.arvatosystems.t9t.components.grid;

import com.arvatosystems.t9t.auth.RoleToPermissionDTO;
import com.arvatosystems.t9t.base.T9tConstants;

import de.jpaw.bonaparte.api.SearchFilters;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.bonaparte.pojos.api.LongFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.UnicodeFilter;
import de.jpaw.bonaparte.pojos.apiw.DataWithTrackingW;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("roleToPermission")
public class RoleToPermissionKeyFromDataProvider implements IKeyFromDataProvider<RoleToPermissionDTO, TrackingBase> {

    @Override
    public SearchFilter getFilterForKey(DataWithTracking<RoleToPermissionDTO, TrackingBase> dwt) {
        final LongFilter tenantFilter = new LongFilter(T9tConstants.TENANT_REF_FIELD_NAME42);
        tenantFilter.setEqualsValue(((DataWithTrackingW<RoleToPermissionDTO, TrackingBase>)dwt).getTenantRef());

        final LongFilter roleFilter = new LongFilter("roleRef");
        roleFilter.setEqualsValue(dwt.getData().getRoleRef().getObjectRef());

        final UnicodeFilter permissionFilter = new UnicodeFilter("permissionId");
        permissionFilter.setEqualsValue(dwt.getData().getPermissionId());

        return SearchFilters.and(tenantFilter, SearchFilters.and(roleFilter, permissionFilter));
    }
}
