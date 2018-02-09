package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.Bandbox;

public interface ILongBandboxFactory {
    IDataField<Bandbox, Long> createBandbox(DataFieldParameters params);
}
