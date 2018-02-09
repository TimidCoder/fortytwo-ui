package com.arvatosystems.t9t.context.bpmn;

import com.arvatosystems.t9t.bpmn.ProcessExecutionStatusDTO;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.components.tools.JumpTool;
import com.arvatosystems.t9t.context.IGridContextMenu;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("bpmnStatus.ctx.toBpmnDef")
public class ShowDefsContextMenuHandler implements IGridContextMenu<ProcessExecutionStatusDTO> {

    @Override
    public void selected(Grid28 lb, DataWithTracking<ProcessExecutionStatusDTO, TrackingBase> dwt) {
        ProcessExecutionStatusDTO dto = dwt.getData();
        JumpTool.jump("screens/data_admin/processDefinition28.zul", "processDefinitionId", dto.getProcessDefinitionId(), "screens/data_admin/bpmnStatus28.zul");
    }
}
