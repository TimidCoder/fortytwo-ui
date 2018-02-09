package com.arvatosystems.t9t.component.datafields;

import de.jpaw.bonaparte.pojos.meta.EnumDataItem;
import de.jpaw.bonaparte.pojos.meta.EnumDefinition;

public class EnumDataField extends AbstractEnumDataField<Enum> {
    protected final EnumDefinition ed;

    public EnumDataField(DataFieldParameters params, String enumDtoRestriction) {
        super(params, ((EnumDataItem)params.cfg).getBaseEnum().getName(), enumDtoRestriction);
        ed = ((EnumDataItem)cfg).getBaseEnum();

        setEnumConstraintsAndModel(ed);
    }
}
