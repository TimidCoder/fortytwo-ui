package com.arvatosystems.t9t.tfi.model.bean;

/**
 * General bean for combobox entries.
 * @author INCI02
 *
 */
public class ComboBoxItem {

    /** name of the combobox entry. This will be shown on frontend **/
    private String name;
    /** value of the combobox entry. **/
    private String value;

    /**
     * Constructor.
     * @param name of the combobox entry. This will be shown on frontend .
     * @param value of the combobox entry.
     */
    public ComboBoxItem(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the name.
     * @return name
     */
    public final String getName() {
        return name;
    }
    /**
     *
     * @param name set name.
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the value.
     * @return value
     */
    public final String getValue() {
        return value;
    }

    /**
     * @param value set value.
     */
    public final void setValue(final String value) {
        this.value = value;
    }

}
