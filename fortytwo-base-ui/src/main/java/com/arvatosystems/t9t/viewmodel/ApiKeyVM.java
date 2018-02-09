package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.auth.ApiKeyDTO;
import com.arvatosystems.t9t.auth.ApiKeyRef;
import com.arvatosystems.t9t.auth.PermissionsDTO;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;

import de.jpaw.bonaparte.pojos.api.DataWithTracking;

@Init(superclass = true)
public class ApiKeyVM extends CrudSurrogateKeyVM<ApiKeyRef, ApiKeyDTO, FullTrackingWithVersion> {

    // min/maxPermissions should be null by default, which means inherit from user

    @Override
    protected void clearData() {
        super.clearData();
        if (data.getPermissions() == null)
            data.setPermissions(new PermissionsDTO());
    }

    @Override
    protected void loadData(DataWithTracking<ApiKeyDTO, FullTrackingWithVersion> dwt) {
        super.loadData(dwt);
        if (data.getPermissions() == null)
            data.setPermissions(new PermissionsDTO());
    }
}
