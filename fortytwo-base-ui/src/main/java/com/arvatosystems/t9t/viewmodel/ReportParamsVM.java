package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;

import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;
import com.arvatosystems.t9t.rep.ReportParamsDTO;
import com.arvatosystems.t9t.rep.ReportParamsRef;
import com.arvatosystems.t9t.services.T9TMessagingDAO;

import de.jpaw.dp.Jdp;

@Init(superclass = true)
public class ReportParamsVM extends CrudSurrogateKeyVM<ReportParamsRef, ReportParamsDTO, FullTrackingWithVersion> {

    private final T9TMessagingDAO messagingDAO = Jdp.getRequired(T9TMessagingDAO.class);

    @Override
    @Command
    public void commandSave() {

        boolean proceed = true;

        // ReportConfigDTO config = getReportConfig(data.getReportConfigRef());

        if (data.getIntervalCategory() == null) {
            Messagebox.show(session.translate("reportParams", "invalid.by.intervalCategory"));
            return;
        }

        switch (data.getIntervalCategory()) {
        case BY_TIME: {
            if (data.getInterval() == null) {
                Messagebox.show(session.translate("reportParams", "invalid.by.time"));
                proceed = false;
            }
            break;
        }
        case BY_DURATION: {
            if (data.getIntervalDays() == null || data.getIntervalSeconds() == null) {
                Messagebox.show(session.translate("reportParams", "invalid.by.duration"));
                proceed = false;
            }
            break;
        }
        case BY_RANGE: {
            if (data.getFromDate() == null || data.getToDate() == null) {
                Messagebox.show(session.translate("reportParams", "invalid.by.range"));
                proceed = false;
            }
            break;
        }
        }

        if (proceed) {
            super.commandSave();
        }
    }

    @Command
    public void runReport() throws ReturnCodeException {
        Long sinkRef = messagingDAO.runReportRequest(this.getData());
        if (sinkRef != null) {
            messagingDAO.downloadSinkAndSave(sinkRef);
        }
    }
}
