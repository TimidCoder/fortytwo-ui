package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.Textbox;

import de.jpaw.bonaparte.core.BonaparteJsonEscaper;
import de.jpaw.json.JsonParser;

public class ElementDataField extends AbstractDataField<Textbox, Object> {
    protected final Textbox c = new Textbox();

    @Override
    public boolean empty() {
        return c.getValue() == null || c.getValue().length() == 0;
    }

    public ElementDataField(DataFieldParameters params) {
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
    public Object getValue() {
        if (empty())
            return null;
        // analyse JSON
        return (new JsonParser(c.getValue(), false)).parseElement();
    }

    @Override
    public void setValue(Object data) {
        c.setValue(BonaparteJsonEscaper.asJson(data));
    }
}
