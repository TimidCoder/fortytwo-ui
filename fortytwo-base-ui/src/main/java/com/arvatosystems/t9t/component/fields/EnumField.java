package com.arvatosystems.t9t.component.fields;

import org.zkoss.zul.Comboitem;

import com.arvatosystems.t9t.base.search.EnumFilter;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.meta.EnumDataItem;
import de.jpaw.bonaparte.pojos.meta.EnumDefinition;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;
import de.jpaw.bonaparte.pojos.ui.UIFilterType;

public class EnumField extends EnumBaseField {
    protected final EnumDefinition ed;

    @Override
    public SearchFilter getSearchFilter() {
        Comboitem ci = cb.getSelectedItem();
        if (ci == null || empty())
            return null;
        EnumFilter f = new EnumFilter();
        f.setFieldName(getFieldName());
        f.setEnumPqon(ed.getName());
        f.setEqualsName(ci.getValue());
        return f;
    }

    public EnumField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session) {
        super(fieldname, cfg, desc, gridId, session, ((EnumDataItem)desc).getBaseEnum().getName());
        ed = ((EnumDataItem)desc).getBaseEnum();
        if (cfg.getFilterType() != UIFilterType.EQUALITY) {
            throw new RuntimeException("enum combobox must have equality constraint: " + fieldname);
        }
       createComp(ed, session);
    }
}
