package com.arvatosystems.t9t.context;

import org.zkoss.zul.Messagebox;

import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.msglog.MessageDTO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;
import de.jpaw.util.ApplicationException;

@Singleton
@Named("requests.ctx.showMessage")
public class ShowErrorMessageContextMenuHandler implements IGridContextMenu<MessageDTO> {

    @Override
    public void selected(Grid28 lb, DataWithTracking<MessageDTO, TrackingBase> dwt) {
        MessageDTO m = dwt.getData();
        if (m != null && m.getReturnCode() != null) {
            String text = ApplicationException.codeToString(m.getReturnCode());
            String message = "Return code " + m.getReturnCode() + " means " + text;
            Messagebox.show(message, "Information", Messagebox.OK, Messagebox.INFORMATION);
        }
    }
}
