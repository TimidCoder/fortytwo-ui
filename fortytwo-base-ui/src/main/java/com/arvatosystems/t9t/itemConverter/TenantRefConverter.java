package com.arvatosystems.t9t.itemConverter;

import com.arvatosystems.t9t.tfi.web.ZulUtils;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("tenantRef")
public class TenantRefConverter implements IItemConverter<Long>, ILongItemConverter {

    @Override
    public String getFormattedLabel(Long value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ZulUtils.getTenantIdByRef((Long) value);
    }

    @Override
    public Object getConvertedValue(Long value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ZulUtils.getTenantIdByRef((Long) value);
    }
}
