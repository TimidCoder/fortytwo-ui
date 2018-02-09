package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.batch.SliceTrackingDTO;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.components.tools.JumpTool;
import com.arvatosystems.t9t.services.IT9TMessagingDAO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("sliceTracking.ctx.showSink")
public class ShowSinkForSliceContextMenuHandler implements IGridContextMenu<SliceTrackingDTO> {
    protected final IT9TMessagingDAO messagingDAO = Jdp.getRequired(IT9TMessagingDAO.class);

    @Override
    public boolean isEnabled(DataWithTracking<SliceTrackingDTO, TrackingBase> dwt) {
        SliceTrackingDTO dto = dwt.getData();
        return dto.getLastSinkRef() != null;
    }

    @Override
    public void selected(Grid28 lb, DataWithTracking<SliceTrackingDTO, TrackingBase> dwt) {
        SliceTrackingDTO dto = dwt.getData();
        if (dto.getLastSinkRef() != null)
            JumpTool.jump("screens/report/sink28.zul", "objectRef", dto.getLastSinkRef(), "screens/report/sliceTracking28.zul");
    }
}
