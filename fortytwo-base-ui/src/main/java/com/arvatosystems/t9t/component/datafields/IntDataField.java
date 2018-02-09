package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.Intbox;

import de.jpaw.bonaparte.pojos.meta.BasicNumericElementaryDataItem;

public class IntDataField extends AbstractDataField<Intbox, Integer> {
    protected final Intbox c = new Intbox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public IntDataField(DataFieldParameters params) {
        super(params);
        BasicNumericElementaryDataItem cfg = (BasicNumericElementaryDataItem)params.cfg;
        setConstraints(c, cfg.getIsSigned() ? null : "no negative");
        c.setMaxlength(cfg.getTotalDigits());
    }

    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Intbox getComponent() {
        return c;
    }

    @Override
    public Integer getValue() {
        return c.getValue();
    }

    @Override
    public void setValue(Integer data) {
        c.setValue(data);
    }
}
