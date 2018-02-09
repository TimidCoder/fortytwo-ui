package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.Textbox;

import de.jpaw.bonaparte.pojos.meta.AlphanumericElementaryDataItem;

public class TextDataField extends AbstractDataField<Textbox, String> {
    protected final Textbox c = new Textbox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public TextDataField(DataFieldParameters params) {
        super(params);
        String bonaparteType = params.cfg.getBonaparteType();
        setConstraints(c, bonaparteType.equals("uppercase") ? "/[A-Z]*/" : bonaparteType.equals("lowercase") ? "/[a-z]*/" : null);
        c.setMaxlength(((AlphanumericElementaryDataItem)params.cfg).getLength());
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
    public String getValue() {
        return c.getValue();
    }

    @Override
    public void setValue(String data) {
        c.setValue(data);
    }
}
