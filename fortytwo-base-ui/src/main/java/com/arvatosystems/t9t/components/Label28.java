package com.arvatosystems.t9t.components;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Label;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.base.CrudViewModel;
import com.arvatosystems.t9t.base.FieldMappers;
import com.arvatosystems.t9t.component.ext.IViewModelOwner;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.meta.Multiplicity;
import de.jpaw.bonaparte.util.FieldGetter;

/** Uses the translation of the id as label text.
 * Must be a child of a component which knows a viewModel, to get the data type.
 * Uses that to add an asterisk if the field is required.
 */
public class Label28 extends Cell {
    private static final long serialVersionUID = -7701935514587261940L;
    protected String myId = null;

    @Override
    public void setId(String myId) {
        // do NOT forward to super.setId() because the ID is reserved. Only use it to define the name
        this.myId = myId;
    }

    @Listen("onCreate")
    public void onCreate() {

        Label label = new Label();

        IViewModelOwner vmOwner = GridIdTools.getAnchestorOfType(this, IViewModelOwner.class);
        String viewModelId = GridIdTools.enforceViewModelId(vmOwner);
        CrudViewModel<BonaPortable, TrackingBase> viewModel = vmOwner.getCrudViewModel();
        ApplicationSession as = vmOwner.getSession();
        String strippedFieldname = FieldMappers.stripIndexes(myId);
        FieldDefinition f = FieldGetter.getFieldDefinitionForPathname(viewModel.dtoClass.getMetaData(), strippedFieldname);
        boolean isRequired = f.getIsRequired() && f.getMultiplicity() == Multiplicity.SCALAR;
        String requiredMarker = isRequired ? "*" : "";
        label.setValue(as.translate(viewModelId, myId) + requiredMarker);  // screen + "." + path in screen
        label.setParent(this);
    }
}
