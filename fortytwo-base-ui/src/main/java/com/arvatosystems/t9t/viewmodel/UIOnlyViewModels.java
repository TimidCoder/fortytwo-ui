package com.arvatosystems.t9t.viewmodel;

import com.arvatosystems.t9t.base.CrudViewModel;
import com.arvatosystems.t9t.base.IViewModelContainer;
import com.arvatosystems.t9t.base.misc.Info;

import de.jpaw.bonaparte.pojos.api.TrackingBase;

// pseudo-viewmodels for popups / modal windows
public class UIOnlyViewModels implements IViewModelContainer {
    public static final CrudViewModel<Info, TrackingBase> INFO_VIEW_MODEL =
        new CrudViewModel<Info, TrackingBase>(
            Info.BClass.INSTANCE, null, null, null
        );

    static {
        IViewModelContainer.CRUD_VIEW_MODEL_REGISTRY.putIfAbsent("info",  INFO_VIEW_MODEL);
    }
}
