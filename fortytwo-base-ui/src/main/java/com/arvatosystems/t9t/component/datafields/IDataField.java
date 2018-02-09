package com.arvatosystems.t9t.component.datafields;

import java.util.Map;

import org.zkoss.zk.ui.Component;

import de.jpaw.bonaparte.pojos.meta.FieldDefinition;

/** Interface for the dynamically created fields. */
public interface IDataField<E extends Component, T> {
    /** Returns a translated label for the field. */
    String getLabel();

    /** Returns the field path. */
    String getFieldName();

    /** Returns the metadata. */
    FieldDefinition getFieldDefintion();

    /** Returns the ZK component(s) associated with the field. These are 2 in case of range filters. */
    E getComponent();

    /** Returns the ZK converter expression, or null if none is required. */
    String getConverter();

    /** Returns the ZK converter args, or null if none are required. */
    Map<String,Object> getConverterArgs();

    /** Clears the component's current value. */
    void clear();

    /** Returns if the field is required (must be not null). */
    boolean getIsRequired();

    /** Returns if the field is currently unset. */
    boolean empty();

    T getValue();

    void setValue(T data);

    /** unified entry to Checkbox and InputElements. */
    void setDisabled(boolean disabled);
}
