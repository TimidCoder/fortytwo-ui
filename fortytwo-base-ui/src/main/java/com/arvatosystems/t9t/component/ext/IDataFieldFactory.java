package com.arvatosystems.t9t.component.ext;

import com.arvatosystems.t9t.base.CrudViewModel;
import com.arvatosystems.t9t.component.datafields.DataFieldParameters;
import com.arvatosystems.t9t.component.datafields.IDataField;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.TrackingBase;

public interface IDataFieldFactory {
    IDataField createField(DataFieldParameters params, CrudViewModel<BonaPortable, TrackingBase> crudViewModel);
}
