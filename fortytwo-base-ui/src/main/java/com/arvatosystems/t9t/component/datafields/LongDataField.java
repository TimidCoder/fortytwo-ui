package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.Longbox;

import de.jpaw.bonaparte.pojos.meta.BasicNumericElementaryDataItem;

public class LongDataField extends AbstractDataField<Longbox, Long> {
    protected final Longbox c = new Longbox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public LongDataField(DataFieldParameters params) {
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
    public Longbox getComponent() {
        return c;
    }

    @Override
    public Long getValue() {
        return c.getValue();
    }

    @Override
    public void setValue(Long data) {
        c.setValue(data);
    }
}
