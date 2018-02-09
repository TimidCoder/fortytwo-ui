package com.arvatosystems.t9t.services;

import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.base.uiprefs.UILeanGridPreferences;
import com.arvatosystems.t9t.uiprefsv3.LeanGridConfigDTO;

public interface IT9TBaseDAO {
    public UILeanGridPreferences getLeanGridConfigDTO(String gridId, Long userRef) throws ReturnCodeException;
    public Long setLeanGridConfigDTO(LeanGridConfigDTO leanGridConfigDTO) throws ReturnCodeException;
}
