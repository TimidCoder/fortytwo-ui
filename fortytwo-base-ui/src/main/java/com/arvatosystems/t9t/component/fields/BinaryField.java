package com.arvatosystems.t9t.component.fields;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;
import de.jpaw.bonaparte.pojos.ui.UIFilterType;

public class BinaryField extends TextField {
    public BinaryField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId,
            ApplicationSession session) {
        super(fieldname, cfg, desc, gridId, session);
        if (cfg.getFilterType() != UIFilterType.EQUALITY) {
            throw new RuntimeException("Binary filter must have equality constraint: " + fieldname);
        }
    }

    @Override
    public SearchFilter getSearchFilter() {
        String value = components.get(0).getValue();
        if (value == null || value.length() == 0)
            return null;
        // TODO: there is no BinaryFilter yet. But then, it is very unlikely that it will be required.
//        BinaryFilter f = new BinaryFilter();
//        f.setFieldName(getFieldName());
//        return f;
        return null;
    }
}
