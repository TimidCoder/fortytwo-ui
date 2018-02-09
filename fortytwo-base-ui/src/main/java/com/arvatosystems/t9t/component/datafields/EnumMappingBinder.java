package com.arvatosystems.t9t.component.datafields;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.zkoss.bind.Converter;
import org.zkoss.bind.DefaultBinder;

import com.arvatosystems.t9t.converters.EnumAlphaConverter;

public class EnumMappingBinder extends DefaultBinder {
    private static final long serialVersionUID = -2584640299999716814L;
    public static final Map<String, Converter> converterRegistry = new ConcurrentHashMap<String, Converter>();
    static {
        converterRegistry.put("enumAlpha", new EnumAlphaConverter());
    }
    @Override
    public Converter getConverter(String name) {
        Converter myConverter = converterRegistry.get(name);
        if (myConverter != null)
            return myConverter;
        return super.getConverter(name);
    }
}
