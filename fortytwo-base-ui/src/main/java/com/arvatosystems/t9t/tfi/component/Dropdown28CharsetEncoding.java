package com.arvatosystems.t9t.tfi.component;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Dropdown28CharsetEncoding extends Dropdown28Ext {

    private static final long serialVersionUID = 7804881425211020006L;

    private static final List<String> myModelData = new ArrayList<>(Charset.availableCharsets().keySet());

    public Dropdown28CharsetEncoding() {
        super(myModelData);
        this.setMaxlength(24);
    }
}
