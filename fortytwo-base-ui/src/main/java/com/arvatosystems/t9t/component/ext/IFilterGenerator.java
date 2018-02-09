package com.arvatosystems.t9t.component.ext;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.SearchFilter;

/** Implementations are singletons, injected by qualifier. */
public interface IFilterGenerator {
    SearchFilter createFilter(BonaPortable data);
}
