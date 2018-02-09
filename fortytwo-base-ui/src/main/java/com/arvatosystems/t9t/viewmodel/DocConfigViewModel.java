package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;
import com.arvatosystems.t9t.doc.DocConfigDTO;
import com.arvatosystems.t9t.doc.DocConfigRef;
import com.arvatosystems.t9t.doc.DocEmailReceiverDTO;

import de.jpaw.bonaparte.pojos.api.TrackingBase;

/**
 * @author NGTZ001
 * @param <DATA>
 */
@Init(superclass = true)
public class DocConfigViewModel extends CrudSurrogateKeyVM<DocConfigRef, DocConfigDTO, TrackingBase> {

    @Override
    protected void clearData() {
        super.clearData();
        data.setEmailSettings(new DocEmailReceiverDTO());
    }

}
