package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.components.tools.JumpTool;
import com.arvatosystems.t9t.io.DataSinkDTO;
import com.arvatosystems.t9t.services.IT9TMessagingDAO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("dataSinkConfig.ctx.showSinks")
public class ShowSinksContextMenuHandler implements IGridContextMenu<DataSinkDTO> {
    protected final IT9TMessagingDAO messagingDAO = Jdp.getRequired(IT9TMessagingDAO.class);

    @Override
    public void selected(Grid28 lb, DataWithTracking<DataSinkDTO, TrackingBase> dwt) {
        DataSinkDTO dto = dwt.getData();
        JumpTool.jump("screens/report/sink28.zul", "dataSinkRef", dto.getObjectRef(), "screens/report/dataSink28.zul");
    }
}
