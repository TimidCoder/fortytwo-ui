package com.arvatosystems.t9t.itemConverter;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.enums.BonaEnum;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;
import de.jpaw.enums.XEnum;

@Singleton
@Named("xenum")
public class XenumTranslationConverter implements IItemConverter<XEnum<?>> {

    @Override
    public String getFormattedLabel(XEnum<?> value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ApplicationSession.get().translateEnum((BonaEnum)value.getBaseEnum());
    }

    @Override
    public Object getConvertedValue(XEnum<?> value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value;
    }
}
