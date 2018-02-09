package com.arvatosystems.t9t.tfi.web;

import java.util.List;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.arvatosystems.t9t.auth.TenantRef;
import com.arvatosystems.t9t.authc.api.TenantDescription;

public class TenantDescToTenantRefConverter implements Converter<Object, Object, Component>{

    @Override
    public Object coerceToUi(Object beanProp, Component component, BindContext ctx) {
        Combobox box = (Combobox) component;
        Long  beanPropRef = null;
        if (beanProp instanceof TenantDescription) {
            beanPropRef=((TenantDescription)beanProp).getTenantRef();
        }

        List<Comboitem> listitems = box.getItems();

        for (Comboitem listItem : listitems) {
            TenantDescription tenantDescription = (TenantDescription)listItem.getValue();
            //if (/*listItem.getValue()*/dataWithTrackingW.getData().equals(beanProp)) {
            //if (null!=listItem.getValue() && listItem.getValue().equals(beanProp)) {
            if (null!=tenantDescription && tenantDescription.getTenantRef().equals(beanPropRef)) {
                return listItem;
            }
        }
        return listitems.isEmpty() ? null : listitems.get(0);
    }

    @Override
    public Object coerceToBean(Object compAttr, Component component, BindContext ctx) {

        Combobox box;
        box = (Combobox) component;

        if (box.getSelectedItem() == null) {
            return compAttr;
        } else {
            TenantDescription tenantDescription = (TenantDescription)box.getSelectedItem().getValue();
            TenantRef tenantRef= new TenantRef(tenantDescription.getTenantRef());
            return tenantRef;
        }
    }
}
