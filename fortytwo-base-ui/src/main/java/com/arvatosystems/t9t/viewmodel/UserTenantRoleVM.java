package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.auth.UserTenantRoleDTO;
import com.arvatosystems.t9t.auth.UserTenantRoleInternalKey;
import com.arvatosystems.t9t.auth.UserTenantRoleKey;
import com.arvatosystems.t9t.auth.UserTenantRoleRef;
import com.arvatosystems.t9t.auth.request.UserTenantRoleCrudRequest;
import com.arvatosystems.t9t.base.crud.CrudCompositeKeyRequest;
import com.arvatosystems.t9t.base.crud.CrudCompositeKeyResponse;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.AbstractCrudVM;

@Init(superclass = true)
public class UserTenantRoleVM extends
        AbstractCrudVM<UserTenantRoleRef, UserTenantRoleDTO, FullTrackingWithVersion, CrudCompositeKeyRequest<UserTenantRoleRef, UserTenantRoleDTO, FullTrackingWithVersion>, CrudCompositeKeyResponse<UserTenantRoleInternalKey, UserTenantRoleDTO, FullTrackingWithVersion>> {

    @Override
    protected void clearKey() {
        data.setRoleRef(null);
        data.setUserRef(null);
    }

    @Override
    protected CrudCompositeKeyRequest<UserTenantRoleRef, UserTenantRoleDTO, FullTrackingWithVersion> createCrudWithKey() {
        CrudCompositeKeyRequest<UserTenantRoleRef, UserTenantRoleDTO, FullTrackingWithVersion> crudRq = new UserTenantRoleCrudRequest();
        UserTenantRoleKey key = new UserTenantRoleKey(data.getUserRef(), data.getRoleRef());
        crudRq.setKey(key);
        return crudRq;
    }

    @Override
    protected void clearData() {
        data = crudViewModel.dtoClass.newInstance();
        data.put$Active(true);  // if the DTO has an active field, create it as active by default
        tracking = null;
        tenantRef = session.getTenantRef();
    }
}
