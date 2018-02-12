/*
 * Copyright (c) 2012 - 2018 Arvato Systems GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
