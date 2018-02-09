package com.arvatosystems.t9t.tfi.component;

import java.util.ArrayList;
import java.util.List;

import com.arvatosystems.t9t.translation.be.importer.SupportedLanguagesImporter;

public class Dropdown28LanguageCode extends Dropdown28Ext {

    private static final long serialVersionUID = 7804881425211020007L;

    private static final List<String> myModelData = new ArrayList<>(new SupportedLanguagesImporter().readSupportedLanguages());

    public Dropdown28LanguageCode() {
        super(myModelData);
        this.setMaxlength(8);
    }
}
