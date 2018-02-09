package com.arvatosystems.t9t.tfi.model.bean;



public class ErrorPopupEntity {
    private String popupTitle;
    private String popupImg;
    private String returnCode;
    private String returnMessage;
    private String errorDetails = null;
    private String errorIntroduction;

    public ErrorPopupEntity() {
    }

    public ErrorPopupEntity(String returnCode, String popupTitle, String popupImg, String errorIntroduction) {
        this.returnCode = returnCode;
        this.popupTitle = popupTitle;
        this.errorIntroduction = errorIntroduction;
        this.popupImg = popupImg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getPopupTitle() {
        return popupTitle;
    }

    public void setPopupTitle(String popupTitle) {
        this.popupTitle = popupTitle;
    }

    public String getErrorIntroduction() {
        return errorIntroduction;
    }

    public void setErrorIntroduction(String errorIntroduction) {
        this.errorIntroduction = errorIntroduction;
    }

    public String getPopupImg() {
        return popupImg;
    }

    public void setPopupImg(String popupImg) {
        this.popupImg = popupImg;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }








}
