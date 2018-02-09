package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.auth.PermissionsDTO;
import com.arvatosystems.t9t.auth.TenantDTO;
import com.arvatosystems.t9t.auth.TenantRef;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;

import de.jpaw.bonaparte.pojos.api.auth.Permissionset;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;

@Init(superclass = true)
public class TenantVM extends CrudSurrogateKeyVM<TenantRef, TenantDTO, FullTrackingWithVersion> {

    protected PermissionsDTO defaultTenantPermissions() {
        PermissionsDTO p = new PermissionsDTO();
        p.setMinPermissions(Permissionset.of());
        p.setMaxPermissions(new Permissionset(0xfffff));
        return p;
    }

    @Override
    protected void clearData() {
        super.clearData();
        data.setPermissions(defaultTenantPermissions());
    }

    @Override
    protected void loadData(DataWithTracking<TenantDTO, FullTrackingWithVersion> dwt) {
        super.loadData(dwt);
        if (data.getPermissions() == null)
            data.setPermissions(defaultTenantPermissions());
    }
}
