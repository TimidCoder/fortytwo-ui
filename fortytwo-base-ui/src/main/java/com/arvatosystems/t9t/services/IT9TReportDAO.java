package com.arvatosystems.t9t.services;

import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.base.search.ReadAllResponse;
import com.arvatosystems.t9t.core.CannedRequestDTO;
import com.arvatosystems.t9t.core.CannedRequestRef;

public interface IT9TReportDAO {
    public Long executeCannedRequest(CannedRequestRef ref) throws ReturnCodeException;
    @Deprecated
    public Long executeCannedRequest(Long objectRef) throws ReturnCodeException;
    public ReadAllResponse<CannedRequestDTO, FullTrackingWithVersion> searchCannedJobs() throws ReturnCodeException;


}
