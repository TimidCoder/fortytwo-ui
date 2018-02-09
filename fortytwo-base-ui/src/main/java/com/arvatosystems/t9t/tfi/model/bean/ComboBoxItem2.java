package com.arvatosystems.t9t.tfi.model.bean;

/**
 * All boilerplate only - would be 4 lines in xtend with @Data annotation (and then also have equals and hashCode)
 *
 */
public class ComboBoxItem2<T> {

    /** name of the combobox entry. This will be shown on frontend **/
    private final String name;
    /** value of the combobox entry - often an enum instance. **/
    private final T value;

    public ComboBoxItem2(final String name, final T value) {
        this.name = name;
        this.value = value;
    }

    public final String getName() {
        return name;
    }
    public final T getValue() {
        return value;
    }
}
