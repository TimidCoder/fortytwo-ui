package com.arvatosystems.t9t.component.fields;

import org.zkoss.zul.Textbox;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.api.UnicodeFilter;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;


public class TextField extends AbstractField<Textbox> {
    @Override
    protected Textbox createComponent(String suffix) {
        Textbox textbox = new Textbox();
        textbox.setId(cfg.getFieldName() + suffix);
        textbox.setHflex("1");
        textbox.setPlaceholder(label);
        return textbox;
    }

    @Override
    protected boolean componentEmpty(Textbox c) {
        String s = c.getValue();
        return s == null || s.length() == 0;
    }

    @Override
    public SearchFilter getSearchFilter() {
        if (empty())
            return null;
        // depending on which values are set, create a lower, upper, equals or range filter
        UnicodeFilter f = new UnicodeFilter();
        f.setFieldName(getFieldName());
        String v = components.get(0).getValue();
        switch (cfg.getFilterType()) {
        case EQUALITY:
            f.setEqualsValue(v);
            break;
        case LIKE:
            f.setLikeValue(v.replace('*', '%'));   // SOLR and DB both use '*' now => if it is SOLR, the backend has to replace back
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

    public TextField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session) {
        super(fieldname, cfg, desc, gridId, session);
        createComponents();
    }

    @Override
    public void clear() {
        for (Textbox e : components)
            e.setValue(null);
    }
}
