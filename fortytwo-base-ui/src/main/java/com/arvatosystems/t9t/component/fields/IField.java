package com.arvatosystems.t9t.component.fields;

import java.util.List;

import org.zkoss.zk.ui.Component;

import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.ui.UIFilterType;

/** Interface for the dynamically created fields. */
public interface IField<E extends Component> {
    /** Returns a translated label for the field. */
    String getLabel();

    /** Returns the field path. */
    String getFieldName();

    /** Returns the filter type. */
    UIFilterType getFilterType();

    /** Returns the ZK component(s) associated with the field. These are 2 in case of range filters. */
    List<E> getComponents();

    /** Clears the component's current value. */
    void clear();

    /** Returns if the field(s) are currently unset. */
    boolean empty();

    /** Creates a search filter from the component's current value, or returns null if not appliable.
     * This is the raw filter, not respecting any negation. */
    SearchFilter getSearchFilter();

    /** Returns if the field filter uses inverse logic. */
    boolean isNegated();
}
