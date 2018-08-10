package com.arvatosystems.t9t.tfi.component.dropdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arvatosystems.t9t.base.request.GetQualifiersRequest;
import com.arvatosystems.t9t.base.request.GetQualifiersResponse;
import com.arvatosystems.t9t.services.T9TRemoteUtils;
import com.arvatosystems.t9t.tfi.component.Dropdown28ForQualifier;

import de.jpaw.dp.Jdp;

public class Dropdown28FactoryForQualifiers {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dropdown28FactoryForQualifiers.class);
    private static final ConcurrentMap<String, List<String>> cache = new ConcurrentHashMap<>(64);

    public static Dropdown28ForQualifier createInstance(String pqon) {
        List<String> values = cache.get(pqon);
        if (values == null) {
            LOGGER.info("No cached data for qualifiers of {}, asking backend", pqon);
            T9TRemoteUtils remote = Jdp.getRequired(T9TRemoteUtils.class);
            final GetQualifiersRequest rq = new GetQualifiersRequest();
            rq.setFullyQualifiedClassName("com.arvatosystems.t9t." + pqon);
            GetQualifiersResponse resp = remote.executeExpectOk(rq, GetQualifiersResponse.class);
            List<String> model = new ArrayList<String>(resp.getQualifiers());
            cache.putIfAbsent(pqon, model);
            values = model;
        }
        return new Dropdown28ForQualifier(values);
    }
}
