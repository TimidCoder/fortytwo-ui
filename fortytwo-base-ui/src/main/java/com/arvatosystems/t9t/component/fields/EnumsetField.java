package com.arvatosystems.t9t.component.fields;

import org.zkoss.zul.Comboitem;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.base.search.EnumsetFilter;

import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.meta.EnumDefinition;
import de.jpaw.bonaparte.pojos.meta.EnumSetDefinition;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;
import de.jpaw.bonaparte.pojos.ui.UIFilterType;

public class EnumsetField extends EnumBaseField {
    protected final EnumSetDefinition esd;
    protected final EnumDefinition ed;

    @Override
    public SearchFilter getSearchFilter() {
        Comboitem ci = cb.getSelectedItem();
        if (ci == null || empty())
            return null;
        EnumsetFilter f = new EnumsetFilter();
        f.setFieldName(getFieldName());
        f.setEnumsetPqon(esd.getName());
        f.setEqualsName(ci.getValue());
        f.setSubset(true);               // match any record which includes the selected value, not just equality
        return f;
    }

    public EnumsetField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session, EnumSetDefinition esd) {
        super(fieldname, cfg, desc, gridId, session, esd.getBaseEnum().getName());
        this.esd = esd;
        ed = esd.getBaseEnum();
        if (cfg.getFilterType() != UIFilterType.EQUALITY) {
            throw new RuntimeException("enumset combobox must have equality constraint: " + fieldname);
        }
        createComp(ed, session);
    }
}
