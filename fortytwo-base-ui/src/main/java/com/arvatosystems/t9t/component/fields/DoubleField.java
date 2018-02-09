package com.arvatosystems.t9t.component.fields;

import org.zkoss.zul.Doublebox;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.api.DoubleFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;

public class DoubleField extends AbstractField<Doublebox> {
    @Override
    protected Doublebox createComponent(String suffix) {
        return new Doublebox();
    }

    @Override
    protected boolean componentEmpty(Doublebox c) {
        return c.getValue() == null;
    }

    @Override
    public SearchFilter getSearchFilter() {
        if (empty())
            return null;
        // depending on which values are set, create a lower, upper, equals or range filter
        DoubleFilter f = new DoubleFilter();
        f.setFieldName(getFieldName());
        Double v = components.get(0).getValue();
        switch (cfg.getFilterType()) {
        case EQUALITY:
            f.setEqualsValue(v);
            break;
        case LIKE:
            noLikeFilter();
            f.setEqualsValue(v);
            break;
        case LOWER_BOUND:
            f.setLowerBound(v);
            break;
        case RANGE:
            f.setLowerBound(v);
            f.setUpperBound(components.get(1).getValue());
            break;
        case UPPER_BOUND:
            f.setUpperBound(v);
            break;
        default:
            break;
        }
        return f;
    }

    public DoubleField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session) {
        super(fieldname, cfg, desc, gridId, session);
        createComponents();
    }

    @Override
    public void clear() {
        for (Doublebox e : components)
            e.setValue(null);
    }
}