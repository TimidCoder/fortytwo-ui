package com.arvatosystems.t9t.itemConverter;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("java.lang.Integer")
public class IntConverter implements IItemConverter<Integer> {

    @Override
    public boolean isRightAligned() {
        return true;
    }

    @Override
    public String getFormattedLabel(Integer value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value.toString();
    }

    @Override
    public Object getConvertedValue(Integer value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value;
    }
}
