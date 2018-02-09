package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.auth.RoleToPermissionDTO;
import com.arvatosystems.t9t.auth.RoleToPermissionInternalKey;
import com.arvatosystems.t9t.auth.RoleToPermissionKey;
import com.arvatosystems.t9t.auth.RoleToPermissionRef;
import com.arvatosystems.t9t.auth.request.RoleToPermissionCrudRequest;
import com.arvatosystems.t9t.base.crud.CrudCompositeKeyRequest;
import com.arvatosystems.t9t.base.crud.CrudCompositeKeyResponse;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.AbstractCrudVM;

import de.jpaw.bonaparte.pojos.api.OperationType;
import de.jpaw.bonaparte.pojos.api.auth.Permissionset;

@Init(superclass = true)
public class RoleToPermissionVM extends
        AbstractCrudVM<RoleToPermissionInternalKey, RoleToPermissionDTO, FullTrackingWithVersion, CrudCompositeKeyRequest<RoleToPermissionRef, RoleToPermissionDTO, FullTrackingWithVersion>, CrudCompositeKeyResponse<RoleToPermissionInternalKey, RoleToPermissionDTO, FullTrackingWithVersion>> {

    @Override
    protected void clearKey() {
        data.setRoleRef(null);
        data.setPermissionId(null);
    }

    @Override
    protected CrudCompositeKeyRequest<RoleToPermissionRef, RoleToPermissionDTO, FullTrackingWithVersion> createCrudWithKey() {
        CrudCompositeKeyRequest<RoleToPermissionRef, RoleToPermissionDTO, FullTrackingWithVersion> crudRq = new RoleToPermissionCrudRequest();
        RoleToPermissionKey key = new RoleToPermissionKey(data.getRoleRef(), data.getPermissionId());
        crudRq.setKey(key);
        return crudRq;
    }

    @Override
    protected void clearData() {
        super.clearData();
        data = crudViewModel.dtoClass.newInstance();
        data.put$Active(true);  // if the DTO has an active field, create it as active by default
        data.setPermissionSet(Permissionset.of(OperationType.EXECUTE));  // meaningful default for permision assignment
    }
}
