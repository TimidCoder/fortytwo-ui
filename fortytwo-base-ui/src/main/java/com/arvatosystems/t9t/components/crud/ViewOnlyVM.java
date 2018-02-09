package com.arvatosystems.t9t.components.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;

@Init(superclass=true)
public class ViewOnlyVM<DTO extends BonaPortable, TRACKING extends TrackingBase> extends AbstractViewOnlyVM<DTO, TRACKING> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ViewOnlyVM.class);

    @Command
    @NotifyChange("*")
    public void setSelectionData(@BindingParam("dwt") DataWithTracking<DTO, TRACKING> dwt) {
        if (dwt != null) {
            LOGGER.debug("setSelectionData(some data)");
            loadData(dwt);
        } else {
            LOGGER.debug("setSelectionData(null)");
            clearData();
        }
    }
}
