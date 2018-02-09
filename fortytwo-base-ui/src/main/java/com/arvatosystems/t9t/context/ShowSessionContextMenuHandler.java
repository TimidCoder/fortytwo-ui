package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.components.tools.JumpTool;
import com.arvatosystems.t9t.msglog.MessageDTO;
import com.arvatosystems.t9t.services.IT9TMessagingDAO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("requests.ctx.toSession")
public class ShowSessionContextMenuHandler implements IGridContextMenu<MessageDTO> {
    protected final IT9TMessagingDAO messagingDAO = Jdp.getRequired(IT9TMessagingDAO.class);

    @Override
    public void selected(Grid28 lb, DataWithTracking<MessageDTO, TrackingBase> dwt) {
        MessageDTO dto = dwt.getData();
        JumpTool.jump("screens/monitoring/sessions28.zul", "objectRef", dto.getSessionRef(), "screens/monitoring/requests28.zul");
    }
}
