package com.arvatosystems.t9t.tfi.general;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class DataUtils {

    /**
     * Modify the request by field name and the params value.
     *
     * @param request
     * @param field
     * @param value
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static final <REQUEST> void modifyData(REQUEST request, String field, Object value) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.copyProperty(request, field, value);
    }

}
