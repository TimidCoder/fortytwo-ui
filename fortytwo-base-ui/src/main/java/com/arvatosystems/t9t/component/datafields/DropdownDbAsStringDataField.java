package com.arvatosystems.t9t.component.datafields;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zul.Comboitem;

import com.arvatosystems.t9t.tfi.component.dropdown.Dropdown28Db;
import com.arvatosystems.t9t.tfi.component.dropdown.IDropdown28DbFactory;
import com.arvatosystems.t9t.base.search.Description;

import de.jpaw.bonaparte.pojos.apiw.Ref;

public class DropdownDbAsStringDataField extends AbstractDataField<Dropdown28Db<Ref>, String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DropdownDbAsStringDataField.class);

    protected final Dropdown28Db<Ref> c;
    protected final IDropdown28DbFactory<Ref> factory;

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public DropdownDbAsStringDataField(DataFieldParameters params, String dropdownType, IDropdown28DbFactory<Ref> dbFactory) {
        super(params);
        factory = dbFactory;
        c = dbFactory.createInstance();
        setConstraints(c, null);
    }

    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Dropdown28Db<Ref> getComponent() {
        return c;
    }

    @Override
    public String getValue() {
        String res1 = c.getValue();
        Comboitem res = c.getSelectedItem();

        LOGGER.debug("getValue({}) called, value is {}, item is {}: {}",
            getFieldName(),
            res1,
            res == null ? "NULL" : res.getClass().getCanonicalName(), res);
        if (res1 == null)
            return null;
        Description desc = c.lookupById(res1);
        return desc == null ? null : desc.getId();
    }

    @Override
    public void setValue(String data) {
        Description desc = data == null ? null : c.lookupById(data);
        LOGGER.debug("{}.setValue(): setting {} results in {}", getFieldName(), data, desc);
        c.setValue(desc == null ? null : desc.getId());
    }
}