package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.base.output.ExportStatusEnum;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.io.SinkDTO;
import com.arvatosystems.t9t.io.request.ProcessCamelRouteRequest;
import com.arvatosystems.t9t.services.T9TRemoteUtils;

import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("sinkSearch.ctx.camelRetransfer")
public class CamelRetransferContextMenuHandler implements IGridContextMenu<SinkDTO> {
    protected final T9TRemoteUtils messaging = Jdp.getRequired(T9TRemoteUtils.class);

    @Override
    public boolean isEnabled(DataWithTracking<SinkDTO, TrackingBase> dwt) {
        ExportStatusEnum status = dwt.getData().getCamelTransferStatus();
        return status != null && status != ExportStatusEnum.RESPONSE_OK;
    }

    @Override
    public void selected(Grid28 lb, DataWithTracking<SinkDTO, TrackingBase> dwt) {
        messaging.executeExpectOk(new ProcessCamelRouteRequest(dwt.getData().getObjectRef()));
    }
}
