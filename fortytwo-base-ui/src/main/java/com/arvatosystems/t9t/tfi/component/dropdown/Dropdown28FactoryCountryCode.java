package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.tfi.component.Dropdown28Country;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("countryCode")
@Singleton
public class Dropdown28FactoryCountryCode implements IDropdown28BasicFactory<Dropdown28Country> {

    @Override
    public String getDropdownId() {
        return "countryCode";
    }

    @Override
    public Dropdown28Country createInstance() {
        return new Dropdown28Country();
    }
}
