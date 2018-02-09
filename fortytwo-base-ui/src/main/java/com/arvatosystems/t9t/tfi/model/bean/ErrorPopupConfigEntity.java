package com.arvatosystems.t9t.tfi.model.bean;


public class ErrorPopupConfigEntity {
    private String returnCode;
    private String popupTitle;
    private String errorIntroduction;
    private String popupImg;

    public ErrorPopupConfigEntity(String returnCode, String popupTitle, String popupImg, String errorIntroduction) {
        super();
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

    @Override
    public String toString() {
        return "ErrorPopupEntity [returnCode=" + returnCode + ", popupTitle=" + popupTitle + ", errorIntroduction=" + errorIntroduction + ", popupImg="
                + popupImg + "]";
    }






}
