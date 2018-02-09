package com.arvatosystems.t9t.context;

import java.util.Map;

import com.arvatosystems.t9t.base.api.RequestParameters;
import com.arvatosystems.t9t.base.api.ServiceRequest;
import com.arvatosystems.t9t.base.api.ServiceResponse;
import com.arvatosystems.t9t.base.misc.Info;
import com.arvatosystems.t9t.components.Grid28;
import com.arvatosystems.t9t.components.ModalWindows;
import com.arvatosystems.t9t.msglog.MessageDTO;
import com.arvatosystems.t9t.msglog.request.RetrieveParametersRequest;
import com.arvatosystems.t9t.msglog.request.RetrieveParametersResponse;
import com.arvatosystems.t9t.services.T9TRemoteUtils;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.core.MapParser;
import de.jpaw.dp.Jdp;
import de.jpaw.json.JsonParser;

public abstract class AbstractShowParametersContextHandler implements IGridContextMenu<MessageDTO> {
    protected final T9TRemoteUtils remoteUtils = Jdp.getRequired(T9TRemoteUtils.class);

    protected RequestParameters getRequest(Long processRef) {
        return getParameters(processRef, true, false).getRequestParameters();
    }

    protected ServiceResponse getResponse(Long processRef) {
        return getParameters(processRef, false, true).getServiceResponse();
    }

    protected RetrieveParametersResponse getParameters(Long processRef, boolean rq, boolean rs) {
        RetrieveParametersRequest req = new RetrieveParametersRequest();
        req.setProcessRef(processRef);
        req.setRequestParameters(rq);
        req.setServiceResponse(rs);
        return remoteUtils.executeExpectOk(req, RetrieveParametersResponse.class);
    }

    protected void showInModelWindow(Grid28 lb, String text, final boolean rerunOnOK) {
        Info info = new Info();
        info.setText(text);
        ModalWindows.runModal("/context/info28.zul", lb.getParent(), info, false, (d) -> {
            if (rerunOnOK) {
                Map<String, Object> jsonAsMap = (new JsonParser(d.getText(), false)).parseObject();
                BonaPortable rp = MapParser.asBonaPortable(jsonAsMap, ServiceRequest.meta$$requestParameters);
                if (rp instanceof RequestParameters) {
                    remoteUtils.executeExpectOk((RequestParameters)rp);
                }
            }
        });
    }
}
