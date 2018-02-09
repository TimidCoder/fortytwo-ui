package com.arvatosystems.t9t.components.crud;

import com.arvatosystems.t9t.components.crud.AbstractCrudVM.CrudMode;

public interface ICrudNotifier {
    void setRefresher(Object eventData);
    void setCurrentMode(CrudMode currentMode);
}
