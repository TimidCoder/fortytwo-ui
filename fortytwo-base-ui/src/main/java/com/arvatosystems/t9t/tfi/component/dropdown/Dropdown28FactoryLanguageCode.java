package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.tfi.component.Dropdown28LanguageCode;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("languageCode")
@Singleton
public class Dropdown28FactoryLanguageCode implements IDropdown28BasicFactory<Dropdown28LanguageCode> {

    @Override
    public String getDropdownId() {
        return "languageCode";
    }

    @Override
    public Dropdown28LanguageCode createInstance() {
        return new Dropdown28LanguageCode();
    }
}
