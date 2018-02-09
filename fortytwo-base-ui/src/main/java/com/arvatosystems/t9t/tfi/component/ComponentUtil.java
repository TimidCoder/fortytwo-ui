package com.arvatosystems.t9t.tfi.component;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.util.Locales;

public class ComponentUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentUtil.class);

    // will look like:
    // data.addressLines[0]  --> data.addressLines01
    public static String computeFieldForUnrolledListSorting(String fieldName) {
        if (fieldName == null) {
            return null;
        }
        if (fieldName.indexOf('[') < 0)
            return fieldName;  // shortcut: not index fields
        String[] tokens = fieldName.split("\\[|\\]"); // split by "[" and "]"
        StringBuilder preparedFieldName = new StringBuilder();
        for (String token : tokens) {
            if (NumberUtils.isDigits(token)) {
                token = StringUtils.leftPad(String.valueOf(Integer.parseInt(token) + 1), 2, "0"); // fill with leading 0 size two digits
            }
            preparedFieldName.append(token);
        }

        return preparedFieldName.toString();
    }

    public static DecimalFormat getLocalizedDecimalFormat(String pattern, int minimumFractionDigits) {
        final DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locales.getCurrent());
        df.applyPattern(pattern);
        df.setMinimumFractionDigits(minimumFractionDigits);
        return df;
    }
}
