package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.base.search.LeanSearchRequest;
import com.arvatosystems.t9t.core.CannedRequestDTO;
import com.arvatosystems.t9t.core.CannedRequestKey;
import com.arvatosystems.t9t.core.CannedRequestRef;
import com.arvatosystems.t9t.core.request.LeanCannedRequestSearchRequest;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("cannedRequestId")
@Singleton
public class Dropdown28FactoryCannedRequest implements IDropdown28DbFactory<CannedRequestRef> {

    @Override
    public String getDropdownId() {
        return "cannedRequestId";
    }

    @Override
    public LeanSearchRequest getSearchRequest() {
        return new LeanCannedRequestSearchRequest();
    }

    @Override
    public CannedRequestRef createRef(Long ref) {
        return new CannedRequestRef(ref);
    }

    @Override
    public CannedRequestKey createKey(String id) {
        return new CannedRequestKey(id);
    }

    @Override
    public Dropdown28Db<CannedRequestRef> createInstance() {
        return new Dropdown28Db<CannedRequestRef>(this);
    }

    @Override
    public String getIdFromKey(CannedRequestRef key) {
        if (key instanceof CannedRequestKey)
            return ((CannedRequestKey)key).getRequestId();
        if (key instanceof CannedRequestDTO)
            return ((CannedRequestDTO)key).getRequestId();
        return null;
    }
}
