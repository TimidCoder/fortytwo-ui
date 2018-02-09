package com.arvatosystems.t9t.tfi.component;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTimeZone;

public class Dropdown28TimeZoneId extends Dropdown28Ext {

    private static final long serialVersionUID = 7804881425211020005L;

    private static final List<String> myModelData = new ArrayList<>(DateTimeZone.getAvailableIDs());

    public Dropdown28TimeZoneId() {
        super(myModelData);
        this.setMaxlength(64);
    }
}
