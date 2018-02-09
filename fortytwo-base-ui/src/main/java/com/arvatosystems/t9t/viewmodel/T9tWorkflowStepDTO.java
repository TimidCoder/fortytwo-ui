package com.arvatosystems.t9t.viewmodel;

import com.arvatosystems.t9t.bpmn.T9tAbstractWorkflowStep;
import java.util.Map;

public class T9tWorkflowStepDTO extends T9tAbstractWorkflowStep {
     /**
     *
     */
    private static final long serialVersionUID = -981224794305006193L;
    String                stepName;
    Map<String, Object>   parameters;


    public String getStepName() {
        return stepName;
    }
    public void setStepName(String stepName) {
        this.stepName = stepName;
    }
    public Map<String, Object> getParameters() {
        return parameters;
    }
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
        result = prime * result + ((stepName == null) ? 0 : stepName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        T9tWorkflowStepDTO other = (T9tWorkflowStepDTO) obj;
        if (parameters == null) {
            if (other.parameters != null)
                return false;
        } else if (!parameters.equals(other.parameters))
            return false;
        if (stepName == null) {
            if (other.stepName != null)
                return false;
        } else if (!stepName.equals(other.stepName))
            return false;
        return true;
    }



}
