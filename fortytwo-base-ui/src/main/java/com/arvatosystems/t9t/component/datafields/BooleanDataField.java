package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;

// this is an exception because it does not inherit from InputElement
public class BooleanDataField extends AbstractCoreDataField<Checkbox, Boolean> {
    protected final Checkbox c = new Checkbox();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public BooleanDataField(DataFieldParameters params) {
        super(params);
        c.setHflex("1");
        // checkbox does not generate onChange events, in order to update the viewmodel, onCheck must be mapped to it
        c.addEventListener(Events.ON_CHECK, (ev) -> Events.postEvent(Events.ON_CHANGE, c, null));
    }

    @Override
    public void clear() {
        c.setChecked(false);
    }

    @Override
    public Checkbox getComponent() {
        return c;
    }

    @Override
    public Boolean getValue() {
        return c.isChecked();
    }

    @Override
    public void setValue(Boolean data) {
        c.setChecked(Boolean.TRUE.equals(data));
    }

    @Override
    public void setDisabled(boolean disabled) {
        c.setDisabled(disabled);
    }
}
