package com.arvatosystems.t9t.tfi.component.dropdown;

import org.zkoss.zul.Combobox;

public interface IDropdown28BasicFactory<T extends Combobox> {

    /** Returns the ID of the Dropdown (the ID is also referenced in the "dropdown" property of the bon file). */
    String getDropdownId();

    /** Creates an instance of the dropdown control (ZK combobox instance). */
    T createInstance();
}
