package com.arvatosystems.t9t.component.fields;

import java.math.BigDecimal;

import org.zkoss.zul.Decimalbox;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.api.DecimalFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;

public class DecimalField extends AbstractField<Decimalbox> {
    @Override
    protected Decimalbox createComponent(String suffix) {
        return new Decimalbox();
    }

    @Override
    protected boolean componentEmpty(Decimalbox c) {
        return c.getValue() == null;
    }

    @Override
    public SearchFilter getSearchFilter() {
        if (empty())
            return null;
        // depending on which values are set, create a lower, upper, equals or range filter
        DecimalFilter f = new DecimalFilter();
        f.setFieldName(getFieldName());
        BigDecimal v = components.get(0).getValue();
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

    public DecimalField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session) {
        super(fieldname, cfg, desc, gridId, session);
        createComponents();
    }

    @Override
    public void clear() {
        for (Decimalbox e : components)
            e.setValue((String)null);
    }
}