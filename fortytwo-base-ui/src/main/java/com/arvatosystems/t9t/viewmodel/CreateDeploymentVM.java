package com.arvatosystems.t9t.viewmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Messagebox;

import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.bpmn2.request.CreateDeploymentRequest;
import com.arvatosystems.t9t.bpmn2.request.CreateDeploymentResponse;
import com.arvatosystems.t9t.bpmn2.request.DeploymentResourceDTO;
import com.arvatosystems.t9t.components.crud.ViewOnlyVM;
import com.arvatosystems.t9t.services.IT9TMessagingDAO;
import com.arvatosystems.t9t.services.T9TRemoteUtils;

import de.jpaw.bonaparte.pojos.api.media.MediaData;
import de.jpaw.dp.Jdp;
import de.jpaw.util.ApplicationException;

@Init(superclass=true)
public class CreateDeploymentVM extends ViewOnlyVM<CreateDeploymentRequest, FullTrackingWithVersion> {

    protected final IT9TMessagingDAO messagingDAO = Jdp.getRequired(IT9TMessagingDAO.class);
    protected final T9TRemoteUtils t9tremoteUtils = Jdp.getRequired(T9TRemoteUtils.class);
    protected static final Logger LOGGER = LoggerFactory.getLogger(CreateDeploymentVM.class);


    @Command
    @NotifyChange("data")
    public void uploadBpmn(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {

        UploadEvent event = (UploadEvent) ctx.getTriggerEvent();
        byte[] uploaded = event.getMedia().getByteData();
        if (uploaded != null) {
            MediaData data = messagingDAO.getUploadedData(event);
            DeploymentResourceDTO dto = new DeploymentResourceDTO(event.getMedia().getName(), data.getRawData());
            //At the time being only require one. Remove the 1 when multiple deployment is supported
            List<DeploymentResourceDTO> deployments = new ArrayList<>(1);
            deployments.add(dto);
            this.data.setResources(deployments);
        }
    }

    @Command
    @NotifyChange("data")
    public void removeBPMNData() {
        this.data.setResources(null);
    }

    @Command
    @NotifyChange("data")
    public void createDeployment() {
        if(!validation()) {
            return;
        }

        CreateDeploymentResponse res = t9tremoteUtils.executeExpectOk(this.data, CreateDeploymentResponse.class);
        if (res.getReturnCode() == ApplicationException.SUCCESS) {
            this.clearData();
        } else {
            LOGGER.error("error while creating deployment: error code:{} message: {} detail: {}", res.getReturnCode(),
                    res.getErrorMessage(), res.getErrorDetails());
        }
    }

    private boolean validation() {
        if(this.data.getResources() == null || this.data.getResources().isEmpty()) {
            Messagebox.show(session.translate("CreateDeploymentVM","err.resourcenotfound"), session.translate("CreateDeploymentVM","com.badinput"), Messagebox.OK,
                    Messagebox.ERROR);
            return false;
        }
        return true;
    }
}
