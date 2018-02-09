package com.arvatosystems.t9t.tfi.web;

import java.util.Iterator;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

/**
 * Convert combobox selected comboitem to value and vice versa.
 */
public class ComboboxSelectedItemConverter implements Converter<Object, Object, Component>, java.io.Serializable {
    private static final long serialVersionUID = 201108171811L;

    @Override
    public Object coerceToUi(Object val, Component comp, BindContext ctx) {
        Combobox cbx = (Combobox) comp;
        if (val != null) {
            for (final Iterator<?> it = cbx.getItems().iterator(); it.hasNext();) {
                final Comboitem ci = (Comboitem) it.next();

                Object bean = ci.getValue();

                if (val.equals(bean)) {
                    return ci;
                }
            }
        }
        return null;
    }

    @Override
    public Object coerceToBean(Object val, Component comp, BindContext ctx) {
        return val != null ? ((Comboitem) val).getValue() : null;
    }

}
