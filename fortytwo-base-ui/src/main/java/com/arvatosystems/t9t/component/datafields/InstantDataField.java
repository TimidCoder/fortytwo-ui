package com.arvatosystems.t9t.component.datafields;

import java.util.Date;

import org.joda.time.Instant;
import org.zkoss.zul.Datebox;

public class InstantDataField extends AbstractDataField<Datebox, Instant> {
    protected final Datebox c = new Datebox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public InstantDataField(DataFieldParameters params) {
        super(params);
        setConstraints(c, null);
        c.setFormat("medium+medium");
    }

    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Datebox getComponent() {
        return c;
    }

    @Override
    public Instant getValue() {
        Date d = c.getValue();
        if (d == null)
            return null;
        return new Instant(d.getTime());
    }

    @Override
    public void setValue(Instant data) {
        c.setValue(data == null ? null : new Date(data.getMillis()));
    }
}
