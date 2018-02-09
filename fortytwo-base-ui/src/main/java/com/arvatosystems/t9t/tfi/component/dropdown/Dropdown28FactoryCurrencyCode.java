package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.tfi.component.Dropdown28Currency;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("currencyCode")
@Singleton
public class Dropdown28FactoryCurrencyCode implements IDropdown28BasicFactory<Dropdown28Currency> {

    @Override
    public String getDropdownId() {
        return "currencyCode";
    }

    @Override
    public Dropdown28Currency createInstance() {
        return new Dropdown28Currency();
    }
}
