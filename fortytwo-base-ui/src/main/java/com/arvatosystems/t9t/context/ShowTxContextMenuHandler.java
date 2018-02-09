package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.base.entities.FullTracking;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.components.tools.JumpTool;
import com.arvatosystems.t9t.io.SinkDTO;
import com.arvatosystems.t9t.services.IT9TMessagingDAO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("sinkSearch.ctx.showTx")
public class ShowTxContextMenuHandler implements IGridContextMenu<SinkDTO> {
    protected final IT9TMessagingDAO messagingDAO = Jdp.getRequired(IT9TMessagingDAO.class);

    @Override
    public void selected(Grid28 lb, DataWithTracking<SinkDTO, TrackingBase> dwt) {
        JumpTool.jump("screens/monitoring/requests28.zul", "objectRef", ((FullTracking)(dwt.getTracking())).getcProcessRef(), "screens/report/sink28.zul");
    }
}
