package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.msglog.MessageDTO;
import com.arvatosystems.t9t.msglog.request.RerunRequest;
import com.arvatosystems.t9t.services.T9TRemoteUtils;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;
import de.jpaw.util.ApplicationException;

@Singleton
@Named("requests.ctx.rerun")
public class RerunRequestContextMenuHandler implements IGridContextMenu<MessageDTO> {
    protected final T9TRemoteUtils remoteUtils = Jdp.getRequired(T9TRemoteUtils.class);

    @Override
    public boolean isEnabled(DataWithTracking<MessageDTO, TrackingBase> dwt) {
        MessageDTO dto = dwt.getData();
        if (ApplicationException.isOk(dto.getReturnCode()))
            return false;
        if (dto.getRerunByProcessRef() != null)
            return false;
        return true;
    }

    @Override
    public void selected(Grid28 lb, DataWithTracking<MessageDTO, TrackingBase> dwt) {
        MessageDTO dto = dwt.getData();
        RerunRequest rq = new RerunRequest();
        rq.setProcessRef(dto.getObjectRef());
        remoteUtils.executeExpectOk(rq);
    }
}
