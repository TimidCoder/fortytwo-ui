package com.arvatosystems.t9t.context.bpmn;

import org.joda.time.Instant;

import com.arvatosystems.t9t.bpmn.ProcessExecutionStatusDTO;
import com.arvatosystems.t9t.bpmn.request.ProcessExecutionStatusCrudRequest;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.context.IGridContextMenu;
import com.arvatosystems.t9t.services.T9TRemoteUtils;

import de.jpaw.bonaparte.pojos.api.OperationType;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("bpmnStatus.ctx.schedule")
public class ProcessScheduleContextMenuHandler implements IGridContextMenu<ProcessExecutionStatusDTO> {
    protected final T9TRemoteUtils remoteUtils = Jdp.getRequired(T9TRemoteUtils.class);

    @Override
    public void selected(Grid28 lb, DataWithTracking<ProcessExecutionStatusDTO, TrackingBase> dwt) {
        ProcessExecutionStatusDTO dto = dwt.getData();
        dto.setYieldUntil(new Instant());
        dto.setReturnCode(null);
        dto.setErrorDetails(null);
        ProcessExecutionStatusCrudRequest rq = new ProcessExecutionStatusCrudRequest();
        rq.setCrud(OperationType.UPDATE);
        rq.setData(dto);
        rq.setKey(dto.getObjectRef());
        remoteUtils.executeExpectOk(rq);
    }
}
