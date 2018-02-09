package com.arvatosystems.t9t.component.datafields;

import com.arvatosystems.t9t.tfi.component.Dropdown28Ext;
import com.arvatosystems.t9t.tfi.component.dropdown.IDropdown28BasicFactory;

/** Prebuilt dropdowns. */
public class DropdownBasicDataField extends AbstractDataField<Dropdown28Ext, String> {
    // private static final Logger LOGGER = LoggerFactory.getLogger(DropdownBasicDataField.class);

    protected final Dropdown28Ext c;

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public DropdownBasicDataField(DataFieldParameters params, String dropdownType, IDropdown28BasicFactory<Dropdown28Ext> dbFactory) {
        super(params);
        c = dbFactory.createInstance();
        setConstraints(c, null);
    }

    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Dropdown28Ext getComponent() {
        return c;
    }

    @Override
    public String getValue() {
        return c.getValue();
    }

    @Override
    public void setValue(String data) {
        c.setValue(data);
    }
}
