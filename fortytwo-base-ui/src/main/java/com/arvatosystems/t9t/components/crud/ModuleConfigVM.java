package com.arvatosystems.t9t.components.crud;

import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.base.crud.CrudAnyKeyResponse;
import com.arvatosystems.t9t.base.crud.CrudModuleCfgRequest;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.base.moduleCfg.ModuleConfigDTO;
import com.arvatosystems.t9t.base.moduleCfg.ModuleConfigKey;

@Init(superclass=true)
public class ModuleConfigVM<DTO extends ModuleConfigDTO>
extends AbstractCrudVM<ModuleConfigKey, DTO, FullTrackingWithVersion, CrudModuleCfgRequest<DTO>, CrudAnyKeyResponse<DTO, FullTrackingWithVersion>> {
    private static final ModuleConfigKey KEY = new ModuleConfigKey();
    static {
        KEY.freeze();
    }

    @Override
    protected CrudModuleCfgRequest<DTO> createCrudWithKey() {
        CrudModuleCfgRequest<DTO> crudRq = (CrudModuleCfgRequest<DTO>) crudViewModel.crudClass.newInstance();
        crudRq.setKey(KEY);
        return crudRq;
    }

    @Override
    protected void clearKey() {
    }
}
