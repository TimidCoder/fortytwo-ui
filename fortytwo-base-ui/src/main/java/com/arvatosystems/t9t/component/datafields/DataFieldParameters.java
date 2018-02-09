package com.arvatosystems.t9t.component.datafields;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.meta.FieldDefinition;

public class DataFieldParameters {
    public final FieldDefinition cfg;
    public final String path;
    public final Boolean overrideRequired;
    public final ApplicationSession as;
    public final String enumZulRestrictions;
    public final String decimals;  // only relevant for decimal fields. null means use precision of bon file. Alphanumeric data means treat it as a currency.

    public DataFieldParameters(FieldDefinition cfg, String path, Boolean overrideRequired, ApplicationSession as, String enumZulRestrictions, String decimals) {
        this.cfg = cfg;
        this.path = path;
        this.overrideRequired = overrideRequired;
        this.as = as;
        this.enumZulRestrictions = enumZulRestrictions;
        this.decimals = decimals;
    }
}
