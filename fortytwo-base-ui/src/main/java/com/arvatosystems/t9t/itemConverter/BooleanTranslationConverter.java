package com.arvatosystems.t9t.itemConverter;

import com.arvatosystems.t9t.tfi.web.ZulUtils;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("java.lang.Boolean")
@Singleton
public class BooleanTranslationConverter implements IItemConverter<Boolean> {

    @Override
    public String getFormattedLabel(Boolean value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ZulUtils.i18nLabel(String.format("com.boolean.%s.format", value));
    }

    @Override
    public Object getConvertedValue(Boolean value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value;
    }
}
