package com.arvatosystems.t9t.component.datafields;

import java.util.Date;
import java.util.TimeZone;

import org.joda.time.LocalDate;
import org.zkoss.zul.Datebox;

public class DayDataField extends AbstractDataField<Datebox, LocalDate> {
    protected final Datebox c = new Datebox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public DayDataField(DataFieldParameters params) {
        super(params);
        setConstraints(c, null);
        c.setFormat("medium");
        c.setTimeZone(TimeZone.getDefault());  // do not convert between user's time zone and UTC here
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
    public LocalDate getValue() {
        Date d = c.getValue();
        if (d == null)
            return null;
        return LocalDate.fromDateFields(d);
    }

    @Override
    public void setValue(LocalDate data) {
        c.setValue(data == null ? null : data.toDate());
    }
}
