package com.arvatosystems.t9t.component.datafields;

import java.util.Date;

import org.joda.time.LocalDateTime;
import org.zkoss.zul.Datebox;

public class TimestampDataField extends AbstractDataField<Datebox, LocalDateTime> {
    protected final Datebox c = new Datebox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public TimestampDataField(DataFieldParameters params) {
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
    public LocalDateTime getValue() {
        Date d = c.getValue();
        if (d == null)
            return null;
        return LocalDateTime.fromDateFields(d);
    }

    @Override
    public void setValue(LocalDateTime data) {
        c.setValue(data == null ? null : data.toDate());
    }
}
