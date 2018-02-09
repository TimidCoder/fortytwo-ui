package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.base.search.LeanSearchRequest;
import com.arvatosystems.t9t.io.DataSinkDTO;
import com.arvatosystems.t9t.io.DataSinkKey;
import com.arvatosystems.t9t.io.DataSinkRef;
import com.arvatosystems.t9t.io.request.LeanDataSinkSearchRequest;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("dataSinkId")
@Singleton
public class Dropdown28FactoryDataSink implements IDropdown28DbFactory<DataSinkRef> {

    @Override
    public String getDropdownId() {
        return "dataSinkId";
    }

    @Override
    public LeanSearchRequest getSearchRequest() {
        return new LeanDataSinkSearchRequest();
    }

    @Override
    public DataSinkRef createRef(Long ref) {
        return new DataSinkRef(ref);
    }

    @Override
    public DataSinkRef createKey(String id) {
        return new DataSinkKey(id);
    }

    @Override
    public Dropdown28Db<DataSinkRef> createInstance() {
        return new Dropdown28Db<DataSinkRef>(this);
    }

    @Override
    public String getIdFromKey(DataSinkRef key) {
        if (key instanceof DataSinkKey)
            return ((DataSinkKey)key).getDataSinkId();
        if (key instanceof DataSinkDTO)
            return ((DataSinkDTO)key).getDataSinkId();
        return null;
    }
}
