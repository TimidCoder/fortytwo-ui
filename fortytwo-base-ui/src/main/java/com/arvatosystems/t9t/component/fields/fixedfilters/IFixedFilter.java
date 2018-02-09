package com.arvatosystems.t9t.component.fields.fixedfilters;

import java.util.function.Supplier;

import de.jpaw.bonaparte.pojos.api.SearchFilter;

/** Filters which can be applied to grids or dropdowns.
 * Implementations are selected by @Named qualifier. */
public interface IFixedFilter extends Supplier<SearchFilter> {
}
