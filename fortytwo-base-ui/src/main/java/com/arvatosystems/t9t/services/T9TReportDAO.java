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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.base.api.ServiceResponse;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.base.search.ReadAllResponse;
import com.arvatosystems.t9t.core.CannedRequestDTO;
import com.arvatosystems.t9t.core.CannedRequestRef;
import com.arvatosystems.t9t.core.request.CannedRequestSearchRequest;
import com.arvatosystems.t9t.core.request.ExecuteCannedRequest;

import de.jpaw.dp.Jdp;
import de.jpaw.dp.Singleton;

@Singleton
public class T9TReportDAO /*extends AbstractSinkDAO*/ implements IT9TReportDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(T9TReportDAO.class);
    private T9TRemoteUtils t9tRemoteUtils = Jdp.getRequired(T9TRemoteUtils.class);

    @Override
    public Long executeCannedRequest(CannedRequestRef cannedRequestRef) throws ReturnCodeException {
        //LOGGER.debug("T9TReportDAO.executeCannedRequest with RequestParameters:{}", requestParameters != null ? requestParameters.ret$PQON() : "NULL");
        LOGGER.debug("T9TReportDAO.executeCannedRequest with ref {}", cannedRequestRef);

        try {
            ExecuteCannedRequest executeCannedRequest = new ExecuteCannedRequest();;
            executeCannedRequest.setRequestRef(cannedRequestRef);
            ServiceResponse serviceResponse = t9tRemoteUtils.executeAndHandle(executeCannedRequest, ServiceResponse.class);

            //return findSinkRefInReponse(serviceResponse);
        } catch (Exception e) {
            t9tRemoteUtils.returnCodeExceptionHandler("executeCannedRequest", e);
            return null; // just for the compiler
        }

        return null;
    }

    @Deprecated
    @Override
    public Long executeCannedRequest(Long objectRef) throws ReturnCodeException {
        //LOGGER.debug("T9TReportDAO.executeCannedRequest with RequestParameters:{}", requestParameters != null ? requestParameters.ret$PQON() : "NULL");
        LOGGER.debug("T9TReportDAO.executeCannedRequest with objectRef:{}",objectRef);

        try {
            CannedRequestRef  cannedRequestRef=new CannedRequestRef(objectRef);
            ExecuteCannedRequest executeCannedRequest = new ExecuteCannedRequest();;
            executeCannedRequest.setRequestRef(cannedRequestRef);
            ServiceResponse serviceResponse = t9tRemoteUtils.executeAndHandle(executeCannedRequest, ServiceResponse.class);

            //return findSinkRefInReponse(serviceResponse);
        } catch (Exception e) {
            t9tRemoteUtils.returnCodeExceptionHandler("executeCannedRequest", e);
            return null; // just for the compiler
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ReadAllResponse<CannedRequestDTO, FullTrackingWithVersion>  searchCannedJobs() throws ReturnCodeException {
        //LOGGER.debug("T9TReportDAO.executeCannedRequest with RequestParameters:{}", requestParameters != null ? requestParameters.ret$PQON() : "NULL");
        LOGGER.debug("T9TReportDAO.searchCannedJobs");
        ReadAllResponse<CannedRequestDTO, FullTrackingWithVersion>  response;
        try {
            CannedRequestSearchRequest searchRequest = new CannedRequestSearchRequest();
            //ReadAllResponse<?, ?> serviceResponse = t9tRemoteUtils.executeAndHandle(searchRequest, ReadAllResponse.class);
            //serviceResponse.getDataList();
            //searchRequest.setSortColumns(sortColumns);
            response = t9tRemoteUtils.executeAndHandle(searchRequest, ReadAllResponse.class);




            return response;
        } catch (Exception e) {
            t9tRemoteUtils.returnCodeExceptionHandler("executeCannedRequest", e);
            return null; // just for the compiler
        }

    }



}
