package com.arvatosystems.t9t.component.ext;

import de.jpaw.bonaparte.pojos.api.LongFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.apiw.Ref;
import de.jpaw.dp.Jdp;

public class FilterGenerator {
    private static SearchFilter createFilter(Ref data, String fieldName) {
        final LongFilter l = new LongFilter();
        l.setFieldName(fieldName);
        l.setEqualsValue(data.getObjectRef());
        return l;
    }

    public static IFilterGenerator filterForFieldname(final String fieldName) {
        return (data) -> createFilter((Ref)data, fieldName);
    }

    public static IFilterGenerator filterForName(final String name) {
        return Jdp.getRequired(IFilterGenerator.class, name);
    }
}
