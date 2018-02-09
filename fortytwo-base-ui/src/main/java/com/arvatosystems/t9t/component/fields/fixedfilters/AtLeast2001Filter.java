package com.arvatosystems.t9t.component.fields.fixedfilters;

import org.joda.time.LocalDate;

import de.jpaw.bonaparte.pojos.api.DayFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("atLeast2001")
public class AtLeast2001Filter implements IFixedFilter {
    private static final DayFilter FILTER = new DayFilter("day");
    static {
        FILTER.setLowerBound(new LocalDate(2001,1,1));
        FILTER.freeze();
    }

    @Override
    public SearchFilter get() {
        return FILTER;
    }
}
