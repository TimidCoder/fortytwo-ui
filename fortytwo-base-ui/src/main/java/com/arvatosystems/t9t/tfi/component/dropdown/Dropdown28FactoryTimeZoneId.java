package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.tfi.component.Dropdown28TimeZoneId;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("timeZoneId")
@Singleton
public class Dropdown28FactoryTimeZoneId implements IDropdown28BasicFactory<Dropdown28TimeZoneId> {

    @Override
    public String getDropdownId() {
        return "timeZoneId";
    }

    @Override
    public Dropdown28TimeZoneId createInstance() {
        return new Dropdown28TimeZoneId();
    }
}
