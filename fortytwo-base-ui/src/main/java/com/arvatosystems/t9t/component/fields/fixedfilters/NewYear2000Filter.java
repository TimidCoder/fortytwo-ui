package com.arvatosystems.t9t.component.fields.fixedfilters;

import org.joda.time.LocalDate;

import de.jpaw.bonaparte.pojos.api.DayFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("newYear2000")
public class NewYear2000Filter implements IFixedFilter {
    private static final DayFilter FILTER = new DayFilter("day");
    static {
        FILTER.setEqualsValue(new LocalDate(2000,1,1));
        FILTER.freeze();
    }

    @Override
    public SearchFilter get() {
        return FILTER;
    }
}
