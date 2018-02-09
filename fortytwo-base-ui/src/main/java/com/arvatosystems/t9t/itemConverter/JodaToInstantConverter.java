package com.arvatosystems.t9t.itemConverter;

import org.joda.time.Instant;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("org.joda.time.Instant")
public class JodaToInstantConverter implements IItemConverter<Instant> {

    /**
     * it will return formatted string. defined by {@link #JodaToDateConverter()} or {@link #JodaToDateConverter(String)}
     */
    @Override
    public String getFormattedLabel(Instant value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ApplicationSession.get().format(value);
    }

    /**
     * it will return a java.util.Date object
     */
    @Override
    public Object getConvertedValue(Instant value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ApplicationSession.get().toDate(value);
    }
}
