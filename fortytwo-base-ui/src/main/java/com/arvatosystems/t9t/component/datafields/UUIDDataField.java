package com.arvatosystems.t9t.component.datafields;

import java.util.UUID;

import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;

public class UUIDDataField extends AbstractDataField<Textbox, UUID> {
    protected final Textbox c = new Textbox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public UUIDDataField(DataFieldParameters params) {
        super(params);
        setConstraints(c, "/[a-fA-F0-9-]*/");
        c.setMaxlength(36);
    }

    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Textbox getComponent() {
        return c;
    }

    @Override
    public UUID getValue() {
        String s = c.getValue();
        if (Strings.isNullOrEmpty(s))
            return null;
        return UUID.fromString(c.getValue());
    }

    @Override
    public void setValue(UUID data) {
        c.setValue(data == null ? null : data.toString());
    }
}
