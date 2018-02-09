package com.arvatosystems.t9t.viewmodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;
import com.arvatosystems.t9t.core.CannedRequestDTO;
import com.arvatosystems.t9t.core.CannedRequestRef;
import com.arvatosystems.t9t.services.IT9TReportDAO;

import de.jpaw.dp.Jdp;

// viewModel only required for the button command. This could be done via context menu as well!

@Init(superclass=true)
public class CannedViewModel extends CrudSurrogateKeyVM<CannedRequestRef, CannedRequestDTO, FullTrackingWithVersion> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CannedViewModel.class);

    protected final IT9TReportDAO t9tReportDAO = Jdp.getRequired(IT9TReportDAO.class);

    @Command
    public final void executeCannedRequest() throws ReturnCodeException {
        if (data == null || data.getObjectRef() == null)
            return;
        LOGGER.debug("executeCannedRequest with objectRef {}", data.getObjectRef());
        t9tReportDAO.executeCannedRequest(new CannedRequestRef(data.getObjectRef()));
    }
}
