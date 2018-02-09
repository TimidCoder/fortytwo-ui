package com.arvatosystems.t9t.component.fields.fixedfilters;

import org.joda.time.LocalDate;

import de.jpaw.bonaparte.pojos.api.DayFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("jan2Year2000")
public class Jan2Year2000Filter implements IFixedFilter {
    private static final DayFilter FILTER = new DayFilter("day");
    static {
        FILTER.setEqualsValue(new LocalDate(2000,1,2));
        FILTER.freeze();
    }

    @Override
    public SearchFilter get() {
        return FILTER;
    }
}
