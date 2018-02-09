package com.arvatosystems.t9t.component.fields;

import de.jpaw.bonaparte.pojos.apiw.Ref;

public interface IBandboxConverter {
    /** Converts an object into a text. */
    String describe(Ref dto);

    /** Converts the PQON into the bandbox grid name, null means not required because the qualifier was the grid name already. */
    default String getBandboxgridId() { return null; }
}
