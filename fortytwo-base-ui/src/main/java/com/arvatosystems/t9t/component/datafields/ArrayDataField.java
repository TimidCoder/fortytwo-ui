package com.arvatosystems.t9t.component.datafields;

import java.util.List;

import org.zkoss.zul.Textbox;

import de.jpaw.bonaparte.core.BonaparteJsonEscaper;
import de.jpaw.json.JsonParser;

public class ArrayDataField extends AbstractDataField<Textbox, List<Object>> {
    protected final Textbox c = new Textbox();

    @Override
    public boolean empty() {
        return c.getValue() == null || c.getValue().length() == 0;
    }

    public ArrayDataField(DataFieldParameters params) {
        super(params);
        c.setMultiline(true);
        setConstraints(c, null);
    }
    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Textbox getComponent() {
        return c;
    }

    @Override
    public List<Object> getValue() {
        if (empty())
            return null;
        // analyse JSON
        return (new JsonParser(c.getValue(), false)).parseArray();
    }

    @Override
    public void setValue(List<Object> data) {
        c.setValue(BonaparteJsonEscaper.asJson(data));
    }
}
