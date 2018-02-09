package com.arvatosystems.t9t.component.datafields;

import java.math.BigInteger;

import org.zkoss.zul.Longbox;

import de.jpaw.bonaparte.pojos.meta.BasicNumericElementaryDataItem;

public class NumberDataField extends AbstractDataField<Longbox, BigInteger> {
    protected final Longbox c = new Longbox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public NumberDataField(DataFieldParameters params) {
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
    public BigInteger getValue() {
        Long l = c.getValue();
        return l == null ? null : BigInteger.valueOf(l);
    }

    @Override
    public void setValue(BigInteger data) {
        c.setValue(data == null ? null : data.longValue());
    }
}
