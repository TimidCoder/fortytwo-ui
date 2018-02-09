package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.tfi.component.Dropdown28CharsetEncoding;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("charsetEncoding")
@Singleton
public class Dropdown28FactoryCharsetEncoding implements IDropdown28BasicFactory<Dropdown28CharsetEncoding> {

    @Override
    public String getDropdownId() {
        return "charsetEncoding";
    }

    @Override
    public Dropdown28CharsetEncoding createInstance() {
        return new Dropdown28CharsetEncoding();
    }
}
