package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.auth.SessionDTO;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.components.tools.JumpTool;
import com.arvatosystems.t9t.services.IT9TMessagingDAO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("sessions.ctx.requests")
public class ShowRequestsContextMenuHandler implements IGridContextMenu<SessionDTO> {
    protected final IT9TMessagingDAO messagingDAO = Jdp.getRequired(IT9TMessagingDAO.class);

    @Override
    public void selected(Grid28 lb, DataWithTracking<SessionDTO, TrackingBase> dwt) {
        SessionDTO dto = dwt.getData();
        JumpTool.jump("screens/monitoring/requests28.zul", "sessionRef", dto.getObjectRef(), "screens/monitoring/sessions28.zul");
    }
}
