package com.arvatosystems.t9t.context;

import com.arvatosystems.t9t.base.api.RequestParameters;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.msglog.MessageDTO;

import de.jpaw.bonaparte.core.JsonComposer;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("requests.ctx.showRqAsJson")
public class ShowRequestAsJsonContextHandler extends AbstractShowParametersContextHandler {

    @Override
    public void selected(Grid28 lb, DataWithTracking<MessageDTO, TrackingBase> dwt) {
        MessageDTO dto = dwt.getData();
        RequestParameters rp = super.getRequest(dto.getObjectRef());
        if (rp != null) {
            super.showInModelWindow(lb, JsonComposer.toJsonString(rp), false);
        }
    }
}
