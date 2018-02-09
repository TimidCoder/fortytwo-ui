package com.arvatosystems.t9t.itemConverter;

import com.arvatosystems.t9t.tfi.web.ZulUtils;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("enum")
public class EnumTranslationConverter implements IItemConverter<Enum<?>> {

    @Override
    public String getFormattedLabel(Enum<?> value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ZulUtils.getLabelByKey(value.getClass().getName(), value.name());
    }

    @Override
    public Object getConvertedValue(Enum<?> value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return value;
    }
}
