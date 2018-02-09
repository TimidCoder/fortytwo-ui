package com.arvatosystems.t9t.itemConverter;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("java.lang.Long")
public class LongConverter implements IItemConverter<Long> {

    @Override
    public boolean isRightAligned() {
        return true;
    }

    @Override
    public String getFormattedLabel(Long value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value.toString();
    }

    @Override
    public Object getConvertedValue(Long value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value;
    }
}
