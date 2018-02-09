package com.arvatosystems.t9t.services;

import com.arvatosystems.t9t.base.api.ServiceResponse;
import com.arvatosystems.t9t.base.uiprefs.UILeanGridPreferences;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.uiprefsv3.LeanGridConfigDTO;
import com.arvatosystems.t9t.uiprefsv3.LeanGridConfigKey;
import com.arvatosystems.t9t.uiprefsv3.request.LeanGridConfigCrudRequest;
import com.arvatosystems.t9t.uiprefsv3.request.LeanGridConfigResponse;

import de.jpaw.bonaparte.pojos.api.OperationType;
import de.jpaw.dp.Jdp;
import de.jpaw.dp.Singleton;

@Singleton
public class T9TBaseDAO implements IT9TBaseDAO {
    private T9TRemoteUtils t9tRemoteUtils = Jdp.getRequired(T9TRemoteUtils.class);

    @Override
    public UILeanGridPreferences getLeanGridConfigDTO(String gridId, Long userRef) throws ReturnCodeException {
        LeanGridConfigCrudRequest req = new LeanGridConfigCrudRequest();
        req.setCrud(OperationType.READ);
        LeanGridConfigKey leanGridConfigKey = new LeanGridConfigKey(gridId, 1, userRef);
        req.setNaturalKey(leanGridConfigKey);
        ServiceResponse resp = t9tRemoteUtils.executeAndHandle(req, LeanGridConfigResponse.class);
        return ((LeanGridConfigResponse)resp).getLeanGridConfig();
    }

    @Override
    public Long setLeanGridConfigDTO(LeanGridConfigDTO leanGridConfigDTO) throws ReturnCodeException {
        LeanGridConfigCrudRequest req = new LeanGridConfigCrudRequest();
        req.setCrud(OperationType.MERGE);
        req.setData(leanGridConfigDTO);
        ServiceResponse resp = t9tRemoteUtils.executeAndHandle(req, LeanGridConfigResponse.class);
        return null;
    }

}
