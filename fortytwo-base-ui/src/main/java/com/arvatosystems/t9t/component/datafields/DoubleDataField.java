package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.Doublebox;

import de.jpaw.bonaparte.pojos.meta.BasicNumericElementaryDataItem;

public class DoubleDataField extends AbstractDataField<Doublebox, Double> {
    protected final Doublebox c = new Doublebox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public DoubleDataField(DataFieldParameters params) {
        super(params);
        BasicNumericElementaryDataItem cfg = (BasicNumericElementaryDataItem)params.cfg;
        setConstraints(c, cfg.getIsSigned() ? null : "no negative");
        c.setMaxlength(20);
    }

    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Doublebox getComponent() {
        return c;
    }

    @Override
    public Double getValue() {
        return c.getValue();
    }

    @Override
    public void setValue(Double data) {
        c.setValue(data);
    }
}
