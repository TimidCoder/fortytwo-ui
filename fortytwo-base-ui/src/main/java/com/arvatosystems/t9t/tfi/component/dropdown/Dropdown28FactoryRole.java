package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.auth.RoleDTO;
import com.arvatosystems.t9t.auth.RoleKey;
import com.arvatosystems.t9t.auth.RoleRef;
import com.arvatosystems.t9t.auth.request.LeanRoleSearchRequest;
import com.arvatosystems.t9t.base.search.LeanSearchRequest;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("roleId")
@Singleton
public class Dropdown28FactoryRole implements IDropdown28DbFactory<RoleRef> {

    @Override
    public String getDropdownId() {
        return "roleId";
    }

    @Override
    public LeanSearchRequest getSearchRequest() {
        return new LeanRoleSearchRequest();
    }

    @Override
    public RoleRef createRef(Long ref) {
        return new RoleRef(ref);
    }

    @Override
    public RoleRef createKey(String id) {
        return new RoleKey(id);
    }

    @Override
    public Dropdown28Db<RoleRef> createInstance() {
        return new Dropdown28Db<RoleRef>(this);
    }

    @Override
    public String getIdFromKey(RoleRef key) {
        if (key instanceof RoleKey)
            return ((RoleKey)key).getRoleId();
        if (key instanceof RoleDTO)
            return ((RoleDTO)key).getRoleId();
        return null;
    }
}
