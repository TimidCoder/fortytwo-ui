package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.base.api.ServiceResponse;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.msglog.MessageDTO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.bonaparte.util.ToStringHelper;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("requests.ctx.showResp")
public class ShowResponseContextHandler extends AbstractShowParametersContextHandler {

    @Override
    public void selected(Grid28 lb, DataWithTracking<MessageDTO, TrackingBase> dwt) {
        MessageDTO dto = dwt.getData();
        ServiceResponse rp = super.getResponse(dto.getObjectRef());
        if (rp != null) {
            super.showInModelWindow(lb, ToStringHelper.toStringML(rp), false);
        }
    }
}
