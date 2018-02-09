package com.arvatosystems.t9t.converters;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zul.Combobox;

public class EnumAlphaConverter implements Converter<String, Enum<?>, Combobox> {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Enum coerceToBean(String value, Combobox arg1, BindContext ctx) {
        Class enumClass = (Class) ctx.getAttribute("enumClass");
        return Enum.valueOf(enumClass, value);
    }

    @Override
    public String coerceToUi(Enum<?> myEnum, Combobox arg1, BindContext ctx) {
        return myEnum.name();
    }
}
