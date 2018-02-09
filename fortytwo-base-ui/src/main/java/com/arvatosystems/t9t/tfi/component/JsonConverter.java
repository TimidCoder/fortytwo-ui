package com.arvatosystems.t9t.tfi.component;

import java.io.IOException;
import java.util.Map;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

import de.jpaw.json.BaseJsonComposer;
import de.jpaw.json.JsonException;
import de.jpaw.json.JsonParser;

/**
 * Customer converter implementation to convert Json String to Map of String and Object pairs and vice versa.
 *
 * @author michaellow
 */
public class JsonConverter implements Converter<String, Map<String, Object>, Component> {

    private static final String EMPTY_BRACKET = "{}";

    @Override
    public String coerceToUi(Map<String, Object> jsonMap, Component component, BindContext bindContext) {
        StringBuilder stringBuilder = new StringBuilder();
        if (jsonMap != null) {
            BaseJsonComposer baseJsonComposer = new BaseJsonComposer(stringBuilder);
            try {
                baseJsonComposer.outputJsonObject(jsonMap);
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to convert map data to json string format", e);
            }
        }
        return stringBuilder.toString().equals(EMPTY_BRACKET) ? "" : stringBuilder.toString();
    }

    @Override
    public Map<String, Object> coerceToBean(String jsonString, Component component, BindContext bindContext) {
        if (jsonString != null && !jsonString.equals("")) {
            JsonParser jsonParser = new JsonParser(jsonString, true);
            try {
                return jsonParser.parseObject();
            } catch (JsonException e) {
                throw new IllegalArgumentException("Failed to parse the given json string", e);
            }
        } else {
            return null;
        }
    }
}
