package com.arvatosystems.t9t.itemConverter;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.enums.BonaEnum;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("bonaenum")
public class BonaEnumTranslationConverter implements IItemConverter<BonaEnum> {

    @Override
    public String getFormattedLabel(BonaEnum value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ApplicationSession.get().translateEnum(value);
    }

    @Override
    public Object getConvertedValue(BonaEnum value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value;
    }
}
