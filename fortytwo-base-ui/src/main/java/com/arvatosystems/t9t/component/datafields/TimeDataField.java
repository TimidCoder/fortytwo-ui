package com.arvatosystems.t9t.component.datafields;

import java.util.Date;
import java.util.TimeZone;

import org.joda.time.LocalTime;
import org.zkoss.zul.Timebox;

public class TimeDataField extends AbstractDataField<Timebox, LocalTime> {
    protected final Timebox c = new Timebox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public TimeDataField(DataFieldParameters params) {
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
    public Timebox getComponent() {
        return c;
    }

    @Override
    public LocalTime getValue() {
        Date d = c.getValue();
        if (d == null)
            return null;
        return LocalTime.fromDateFields(d);
    }

    @Override
    public void setValue(LocalTime data) {
        c.setValue(data == null ? null : data.toDateTimeToday().toDate());
    }
}
