package com.arvatosystems.t9t.tfi.web;

import java.util.List;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.arvatosystems.t9t.tfi.component.dropdown.Dropdown28Db;
import com.arvatosystems.t9t.base.search.Description;
import com.google.common.base.Strings;

import de.jpaw.bonaparte.pojos.apiw.Ref;

public class DropdownConverter implements Converter<Object, Object, Component> {

    @Override
    public Object coerceToUi(Object beanProp, Component component, BindContext ctx) {

        Combobox box = (Combobox) component;
        Ref ref = (Ref) beanProp;
        Dropdown28Db<?> dropdown28Db = (Dropdown28Db<?>) component;

        Description description = ref == null ? null : dropdown28Db.lookupByRef(ref.getObjectRef());

        List<Comboitem> listitems = box.getItems();

        if (null != description) {
            for (Comboitem listItem : listitems) {
                if (null != listItem.getValue() && listItem.getValue().equals(description.getId())) {
                    return listItem;
                }
            }
        }

        if (!listitems.isEmpty() && null != description) {
            box.removeItemAt(box.getItemCount() - 1);
            box.appendItem(description.getId());
            return box.getItemAtIndex(box.getItemCount() - 1);
        }

        return listitems.isEmpty() || null == description ? null : listitems.get(0);

    }

    @Override
    public Object coerceToBean(Object compAttr, Component component, BindContext ctx) {
        Combobox box = (Combobox) component;

        String current = box.getValue();
        if (Strings.isNullOrEmpty(current))
            return null;

        Dropdown28Db<?> dropdown28Db = (Dropdown28Db<?>) component;
        Description d = dropdown28Db.lookupById(current.toLowerCase());
        if (d == null)
            return null;

        Ref r = dropdown28Db.getFactory().createKey(d.getId());
        r.setObjectRef(d.getObjectRef());

        if (box.getSelectedItem() == null) {
            return compAttr;
        } else {
            return r;

        }
    }
}
