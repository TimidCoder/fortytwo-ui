package com.arvatosystems.t9t.component.fields;

import org.zkoss.zul.Comboitem;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.base.types.BooleanEnum;

import de.jpaw.bonaparte.pojos.api.BooleanFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.meta.EnumDefinition;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;
import de.jpaw.bonaparte.pojos.ui.UIFilterType;

public class BooleanField extends EnumBaseField {
    protected final EnumDefinition ed;

    @Override
    public SearchFilter getSearchFilter() {
        Comboitem ci = cb.getSelectedItem();
        if (ci == null || empty())
            return null;
        BooleanFilter f = new BooleanFilter();
        f.setFieldName(getFieldName());
        f.setBooleanValue(ci.getValue().equals(BooleanEnum.TRUE.name()));
        return f;
    }

    public BooleanField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session) {
        super(fieldname, cfg, desc, gridId, session, null);
        ed = BooleanEnum.enum$MetaData();
        if (cfg.getFilterType() != UIFilterType.EQUALITY) {
            throw new RuntimeException("boolean combobox must have equality constraint: " + fieldname);
        }
        createComp(ed, session);
    }
}
