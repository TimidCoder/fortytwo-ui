package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.auth.UserDTO;
import com.arvatosystems.t9t.auth.UserKey;
import com.arvatosystems.t9t.auth.UserRef;
import com.arvatosystems.t9t.auth.request.LeanUserSearchRequest;
import com.arvatosystems.t9t.base.search.LeanSearchRequest;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("userId")
@Singleton
public class Dropdown28FactoryUser implements IDropdown28DbFactory<UserRef> {

    @Override
    public String getDropdownId() {
        return "userId";
    }

    @Override
    public LeanSearchRequest getSearchRequest() {
        return new LeanUserSearchRequest();
    }

    @Override
    public UserRef createRef(Long ref) {
        return new UserRef(ref);
    }

    @Override
    public UserRef createKey(String id) {
        return new UserKey(id);
    }

    @Override
    public Dropdown28Db<UserRef> createInstance() {
        return new Dropdown28Db<UserRef>(this);
    }

    @Override
    public String getIdFromKey(UserRef key) {
        if (key instanceof UserKey)
            return ((UserKey)key).getUserId();
        if (key instanceof UserDTO)
            return ((UserDTO)key).getUserId();
        return null;
    }
}
