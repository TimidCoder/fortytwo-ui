package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.base.search.LeanSearchRequest;
import com.arvatosystems.t9t.io.CsvConfigurationDTO;
import com.arvatosystems.t9t.io.CsvConfigurationKey;
import com.arvatosystems.t9t.io.CsvConfigurationRef;
import com.arvatosystems.t9t.io.request.LeanCsvConfigurationSearchRequest;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("csvConfigurationId")
@Singleton
public class Dropdown28FactoryCsvConfiguration implements IDropdown28DbFactory<CsvConfigurationRef> {

    @Override
    public String getDropdownId() {
        return "csvConfigurationId";
    }

    @Override
    public LeanSearchRequest getSearchRequest() {
        return new LeanCsvConfigurationSearchRequest();
    }

    @Override
    public CsvConfigurationRef createRef(Long ref) {
        return new CsvConfigurationRef(ref);
    }

    @Override
    public CsvConfigurationRef createKey(String id) {
        return new CsvConfigurationKey(id);
    }

    @Override
    public Dropdown28Db<CsvConfigurationRef> createInstance() {
        return new Dropdown28Db<CsvConfigurationRef>(this);
    }

    @Override
    public String getIdFromKey(CsvConfigurationRef key) {
        if (key instanceof CsvConfigurationKey)
            return ((CsvConfigurationKey)key).getCsvConfigurationId();
        if (key instanceof CsvConfigurationDTO)
            return ((CsvConfigurationDTO)key).getCsvConfigurationId();
        return null;
    }
}
