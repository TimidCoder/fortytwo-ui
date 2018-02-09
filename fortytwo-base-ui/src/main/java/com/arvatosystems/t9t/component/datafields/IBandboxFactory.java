package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.Bandbox;

public interface IBandboxFactory<T> {
    IDataField<Bandbox, T> createBandbox(DataFieldParameters params);
}
