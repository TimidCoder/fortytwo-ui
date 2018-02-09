package com.arvatosystems.t9t.component.datafields;

import com.arvatosystems.t9t.components.Permissions28;

import de.jpaw.bonaparte.pojos.api.auth.Permissionset;

public class PermissionsetDataField extends AbstractCoreDataField<Permissions28, Permissionset> {
    protected final Permissions28 c = new Permissions28();

    @Override
    public boolean empty() {
        return c.getValue() == null;
    }

    public PermissionsetDataField(DataFieldParameters params) {
        super(params);
    }

    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Permissions28 getComponent() {
        return c;
    }

    @Override
    public Permissionset getValue() {
        return c.getValue();
    }

    @Override
    public void setValue(Permissionset data) {
        c.setValue(data);
    }

    @Override
    public void setDisabled(boolean disabled) {
        // getComponent().setDisabled(disabled);  // TODO
    }
}
