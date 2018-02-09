package com.arvatosystems.t9t.component.datafields;

import org.zkoss.zul.impl.InputElement;

public abstract class AbstractDataField<E extends InputElement, T> extends AbstractCoreDataField<E, T> {

    protected AbstractDataField(DataFieldParameters params) {
        super(params);
    }

    protected String combineConstraints(String a, String b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        return a + "," + b;
    }

    protected void setConstraints(InputElement c, String moreConstraints) {
        c.setHflex("1");
        String noEmpty = isRequired ? "no empty" : null;
        String allConstraints = combineConstraints(noEmpty, moreConstraints);
        if (allConstraints != null)
            c.setConstraint(allConstraints);
    }

    @Override
    public void setDisabled(boolean disabled) {
        getComponent().setDisabled(disabled);
    }
}
