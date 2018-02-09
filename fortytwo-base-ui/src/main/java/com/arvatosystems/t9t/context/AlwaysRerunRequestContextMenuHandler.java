package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.msglog.MessageDTO;
import com.arvatosystems.t9t.msglog.request.RerunUnconditionallyRequest;
import com.arvatosystems.t9t.services.T9TRemoteUtils;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("requests.ctx.alwaysRerun")
public class AlwaysRerunRequestContextMenuHandler implements IGridContextMenu<MessageDTO> {
    protected final T9TRemoteUtils remoteUtils = Jdp.getRequired(T9TRemoteUtils.class);

    @Override
    public void selected(Grid28 lb, DataWithTracking<MessageDTO, TrackingBase> dwt) {
        MessageDTO dto = dwt.getData();
        RerunUnconditionallyRequest rq = new RerunUnconditionallyRequest();
        rq.setProcessRef(dto.getObjectRef());
        remoteUtils.executeExpectOk(rq);
    }
}
