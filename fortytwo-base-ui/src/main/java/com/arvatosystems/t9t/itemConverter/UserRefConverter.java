package com.arvatosystems.t9t.itemConverter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.auth.request.LeanUserSearchRequest;
import com.arvatosystems.t9t.base.search.Description;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;
import de.jpaw.util.ExceptionUtil;

@Singleton
@Named("data.userRef")
public class UserRefConverter implements IItemConverter<Long>, ILongItemConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRefConverter.class);

    private String getUserIdByUserRef(Long ref) {
        if (ref == null)
            return "";
        try {
            // the below call caches users, we do not do a separate backend call per row.
            List<Description> users = ApplicationSession.get().getDropDownData("userId", new LeanUserSearchRequest());
            for (Description d: users) {
                if (ref.equals(d.getObjectRef()))
                    return d.getId();  // replace userRef by userId
            }
            // not found
            return "(" + ref.toString() + ")";
        } catch (Exception e) {
            LOGGER.error("Could not retrieve user list: {}", ExceptionUtil.causeChain(e));
            return ">" + ref.toString() + "<";
        }
    }

    @Override
    public String getFormattedLabel(Long value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return getUserIdByUserRef((Long) value);
    }

    @Override
    public Object getConvertedValue(Long value, BonaPortable wholeDataObject, String fieldName, FieldDefinition meta) {
        return getUserIdByUserRef((Long) value);
    }
}
