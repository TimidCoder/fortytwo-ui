package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;
import com.arvatosystems.t9t.doc.DocEmailCfgDTO;
import com.arvatosystems.t9t.doc.DocEmailCfgRef;
import com.arvatosystems.t9t.doc.DocEmailReceiverDTO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;

@Init(superclass = true)
public class DocEmailConfigViewModel extends CrudSurrogateKeyVM<DocEmailCfgRef, DocEmailCfgDTO, TrackingBase> {


    @Override
    protected void clearData() {
        super.clearData();
        data.setEmailSettings(new DocEmailReceiverDTO());
    }

}
