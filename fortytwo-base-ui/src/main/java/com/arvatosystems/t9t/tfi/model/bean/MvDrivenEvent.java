package com.arvatosystems.t9t.tfi.model.bean;


public class MvDrivenEvent {
    private String eventName;
    private String eventComponentId;
    private Object data;
    private String mvEventLocalization;


    public MvDrivenEvent(String eventName, String eventComponentId, Object data,  String mvEventLocalization) {
        this.eventName = eventName;
        this.eventComponentId = eventComponentId;
        this.data = data;
        this.mvEventLocalization = mvEventLocalization;
    }

    public MvDrivenEvent(String eventName, String eventComponentId,String mvEventLocalization) {
        this(eventName, eventComponentId, null,  mvEventLocalization);
    }


    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventComponentId() {
        return eventComponentId;
    }
    public void setEventComponentId(String eventComponentId) {
        this.eventComponentId = eventComponentId;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getMvEventLocalization() {
        return mvEventLocalization;
    }
    public void setMvEventLocalization(String mvEventLocalization) {
        this.mvEventLocalization = mvEventLocalization;
    }

}
