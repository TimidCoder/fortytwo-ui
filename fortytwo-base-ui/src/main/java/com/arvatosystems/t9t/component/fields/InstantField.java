package com.arvatosystems.t9t.component.fields;

import java.util.Date;

import org.joda.time.Instant;
import org.zkoss.zul.Datebox;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.api.InstantFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;


public class InstantField extends AbstractField<Datebox> {
    @Override
    protected Datebox createComponent(String suffix) {
        Datebox d = new Datebox();
        d.setId(cfg.getFieldName() + suffix);
        d.setHflex("1");
        d.setFormat("medium+medium");
        d.setPlaceholder(label);
        return d;
    }

    @Override
    protected boolean componentEmpty(Datebox c) {
        return c.getValue() == null;
    }

    protected Instant getVal(Datebox d) {
        Date vv = d.getValue();
        return vv == null ? null : new Instant(vv.getTime());
    }

    @Override
    public SearchFilter getSearchFilter() {
        if (empty())
            return null;
        // depending on which values are set, create a lower, upper, equals or range filter
        InstantFilter f = new InstantFilter();
        f.setFieldName(getFieldName());
        Instant v = getVal(components.get(0));
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
            f.setUpperBound(getVal(components.get(1)));
            break;
        case UPPER_BOUND:
            f.setUpperBound(v);
            break;
        default:
            break;
        }
        return f;
    }

    public InstantField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session) {
        super(fieldname, cfg, desc, gridId, session);
        createComponents();
    }

    @Override
    public void clear() {
        for (Datebox e : components)
            e.setValue(null);
    }
}