package com.arvatosystems.t9t.itemConverter;

import org.joda.time.LocalDateTime;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("org.joda.time.LocalDateTime")
public class JodaToDateTimeConverter implements IItemConverter<LocalDateTime> {

    /**
     * it will return formatted string. defined by {@link #JodaToDateConverter()} or {@link #JodaToDateConverter(String)}
     */
    @Override
    public String getFormattedLabel(LocalDateTime value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ApplicationSession.get().format(value);
    }

    /**
     * it will return a java.util.Date object
     */
    @Override
    public Object getConvertedValue(LocalDateTime value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return ApplicationSession.get().toDate(value);
    }
}