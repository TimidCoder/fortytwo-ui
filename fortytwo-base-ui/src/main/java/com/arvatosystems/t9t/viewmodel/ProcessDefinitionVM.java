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
package com.arvatosystems.t9t.viewmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Messagebox;

import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.bpmn.ProcessDefinitionDTO;
import com.arvatosystems.t9t.bpmn.ProcessDefinitionRef;
import com.arvatosystems.t9t.bpmn.T9tAbstractWorkflowStep;
import com.arvatosystems.t9t.bpmn.T9tWorkflow;
import com.arvatosystems.t9t.bpmn.T9tWorkflowStepAddParameters;
import com.arvatosystems.t9t.bpmn.T9tWorkflowStepJavaTask;
import com.arvatosystems.t9t.bpmn.request.DeployNewProcessRequest;
import com.arvatosystems.t9t.bpmn.request.DeployProcessRequest;
import com.arvatosystems.t9t.bpmn.request.GetProcessContentRequest;
import com.arvatosystems.t9t.bpmn.request.GetProcessContentResponse;
import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.google.common.base.Strings;

import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.util.ByteArray;

@Init(superclass = true)
public class ProcessDefinitionVM
        extends CrudSurrogateKeyVM<ProcessDefinitionRef, ProcessDefinitionDTO, FullTrackingWithVersion> {
    private List<T9tWorkflowStepDTO> steps = new ArrayList<>();
    private ByteArray bpmnByte = null;

    @Override
    protected void loadData(DataWithTracking<ProcessDefinitionDTO, FullTrackingWithVersion> dwt) {
        super.loadData(dwt);
        buildUpStepsLines(dwt);
    }

    @Override
    protected void clearData() {
        super.clearData();
        steps.clear();
        bpmnByte = null;
    }

    @Override
    protected void saveHook() {
        List<T9tAbstractWorkflowStep> workflowSteps = new ArrayList<>();

        for (T9tWorkflowStepDTO step : steps) {
            T9tAbstractWorkflowStep t = null;
            if (!Strings.isNullOrEmpty(step.getStepName())) {
                t = new T9tWorkflowStepJavaTask();
                ((T9tWorkflowStepJavaTask) t).setStepName(step.getStepName());
            } else {
                t = new T9tWorkflowStepAddParameters();
                ((T9tWorkflowStepAddParameters) t).setParameters(step.getParameters());
            }
            t.setComment(step.getComment());
            t.setLabel(step.getLabel());

            workflowSteps.add(t);
        }
        if (null == data.getWorkflow()) {
            T9tWorkflow t9tWorkflow = new T9tWorkflow(workflowSteps);
            data.setWorkflow(t9tWorkflow);
        } else {
            data.getWorkflow().setSteps(workflowSteps);
        }
    }

    @Override
    @Command
    public void commandSave() {
        if (null == steps || steps.isEmpty()) {
            Messagebox.show(session.translate("processDefinition", "missingSteps"), session.translate("com", "badinput"), Messagebox.OK, Messagebox.INFORMATION);
        } else if (isInconsistent() != -1) {
            Messagebox.show(session.translate("processDefinition", "inconsistency") + " "+isInconsistent(), session.translate("com", "badinput"),
                    Messagebox.OK, Messagebox.INFORMATION);
        } else {
            super.commandSave();
            if (bpmnByte != null) {
                if (data.getObjectRef() == null) {
                    DeployNewProcessRequest request = new DeployNewProcessRequest(bpmnByte);
                    remoteUtil.executeExpectOk(request);
                } else {
                    DeployProcessRequest request = new DeployProcessRequest(new ProcessDefinitionRef(data.getObjectRef()),bpmnByte);
                    remoteUtil.executeExpectOk(request);
                }
            }
        }
    }

    int isInconsistent() {
        int i = 1;
        for (T9tWorkflowStepDTO wStep : getSteps()) {
            if ((Strings.isNullOrEmpty(wStep.getStepName())
                    && (null == wStep.getParameters() || wStep.getParameters().isEmpty()))
                    || (!Strings.isNullOrEmpty(wStep.getStepName())
                            && (null != wStep.getParameters() && !wStep.getParameters().isEmpty()))) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    @NotifyChange("steps")
    void buildUpStepsLines(DataWithTracking<ProcessDefinitionDTO, FullTrackingWithVersion> dwt) {
        steps.clear();
        if (null != dwt && null != dwt.getData() && null != dwt.getData().getWorkflow()) {
            T9tWorkflowStepDTO tmpSteps;
            for (T9tAbstractWorkflowStep step : dwt.getData().getWorkflow().getSteps()) {
                if (step instanceof T9tWorkflowStepJavaTask || step instanceof T9tWorkflowStepAddParameters) {
                    tmpSteps = new T9tWorkflowStepDTO();
                    tmpSteps.setComment(step.getComment());
                    tmpSteps.setLabel(step.getLabel());
                    if (step instanceof T9tWorkflowStepJavaTask) {
                        tmpSteps.setStepName(((T9tWorkflowStepJavaTask) step).getStepName());
                    } else if (step instanceof T9tWorkflowStepAddParameters) {
                        tmpSteps.setParameters(((T9tWorkflowStepAddParameters) step).getParameters());
                    }

                    steps.add(tmpSteps);
                }
            }
        }
    }

    public List<T9tWorkflowStepDTO> getSteps() {
        return steps;
    }

    @Command
    @NotifyChange("steps")
    public void addSteps() {
        if (CrudMode.NONE != this.getCurrentMode()) {
            T9tWorkflowStepDTO tmpSteps = new T9tWorkflowStepDTO();
            steps.add(tmpSteps);
        }
    }

    @Command
    @NotifyChange("steps")
    public void removeSteps(@BindingParam("step") T9tWorkflowStepDTO step) {
        if (step != null && CrudMode.NONE!=this.getCurrentMode())
            steps.remove(step);
    }

    @Command
    @NotifyChange("steps")
    public void upSteps(@BindingParam("step") T9tWorkflowStepDTO step) {
        if (step != null && CrudMode.NONE!=this.getCurrentMode()) {
            int i = steps.indexOf(step);
            if (i != 0) {
                steps.remove(step);
                steps.add(i - 1, step);
            }
        }
    }

    @Command
    @NotifyChange("steps")
    public void downSteps(@BindingParam("step") T9tWorkflowStepDTO step) {
        if (step != null && CrudMode.NONE!=this.getCurrentMode()) {
            int i = steps.indexOf(step);
            if (i != steps.size()-1) {
                steps.remove(step);
                steps.add(i + 1, step);
            }
        }
    }

    @Command
    public void uploadBpmn(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {

        byte[] uploaded = ((UploadEvent) ctx.getTriggerEvent()).getMedia().getByteData();
        if (uploaded != null) {
            bpmnByte = new ByteArray(uploaded);
        }
    }

    @Command
    public void downloadBpmn(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException, ReturnCodeException {

        if (data.getObjectRef() != null) {
            GetProcessContentRequest request = new GetProcessContentRequest(new ProcessDefinitionRef(data.getObjectRef()));
            GetProcessContentResponse response = remoteUtil.executeAndHandle(request, GetProcessContentResponse.class);

            if (response.getContent() != null && response.getContent().getBytes().length != 0) {
                String ctype = "text/plain";
                String format = "content.bpmn20.xml";
                Media media = new AMedia(data.getProcessDefinitionId(), format, ctype, response.getContent().asByteArrayInputStream());
                Filedownload.save(media);
            }
        }
    }
}
