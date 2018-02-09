package com.arvatosystems.t9t.component.datafields;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import de.jpaw.bonaparte.pojos.meta.EnumDataItem;
import de.jpaw.bonaparte.pojos.meta.EnumDefinition;

public class EnumAlphaDataField extends AbstractEnumDataField<Enum> {
    protected final Class<? extends Enum<?>> enumClass;
    protected final Map<String,Object> converterArg;
    protected final EnumDefinition ed;

    public EnumAlphaDataField(DataFieldParameters params, String enumDtoRestriction) {
        super(params, ((EnumDataItem)params.cfg).getBaseEnum().getName(), enumDtoRestriction);
        ed = ((EnumDataItem)cfg).getBaseEnum();
        enumClass = ed.getClassRef();
        converterArg = ImmutableMap.of("enumClass", enumClass);

        setEnumConstraintsAndModel(ed);
    }

    @Override
    public String getConverter() {
        return "enumAlpha";
    }

    @Override
    public Map<String,Object> getConverterArgs() {
        return null;
    }
}
