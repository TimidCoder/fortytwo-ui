package com.arvatosystems.t9t.converters;

import java.util.UUID;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zul.Textbox;

public class UUIDConverter implements Converter<String, UUID, Textbox> {
    @Override
    public UUID coerceToBean(String value, Textbox arg1, BindContext arg2) {
        return UUID.fromString(value);
    }

    @Override
    public String coerceToUi(UUID uuid, Textbox arg1, BindContext arg2) {
        return uuid.toString();
    }
}
