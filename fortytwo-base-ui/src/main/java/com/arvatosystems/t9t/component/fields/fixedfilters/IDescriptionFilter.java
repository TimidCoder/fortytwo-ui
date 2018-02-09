package com.arvatosystems.t9t.component.fields.fixedfilters;

import java.util.List;

import com.arvatosystems.t9t.base.search.Description;

/** Allows to specify filters based on result data for dropdowns.
 * Implementations are selected by @Named qualifier. */
public interface IDescriptionFilter {
    List<Description> filter(List<Description> input);
}
