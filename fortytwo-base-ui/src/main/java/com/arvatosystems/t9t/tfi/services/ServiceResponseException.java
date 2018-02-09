package com.arvatosystems.t9t.tfi.services;

import com.arvatosystems.t9t.tfi.general.Constants;


public class ServiceResponseException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1105145029339557495L;
    private int returnCode =  Constants.ErrorCodes.RETURN_CODE_SUCCESS;
    private String returnMessage = null;
    private String errorDetails = null;

    public ServiceResponseException(int returnCode, String returnMessage, String errorDetails) {
        super("Returncode: " + returnCode + " -- " + returnMessage + " -- " + errorDetails);
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.errorDetails = errorDetails;
    }

    /**
     * @return the returnCode
     */
    public int getReturnCode() {
        return returnCode;
    }


    public final String getReturnMessage() {
        return returnMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }



    public final ServiceResponseException getReturnCodeMessage() {
        ServiceResponseException errorMessage = null;
        if (this.returnCode != Constants.ErrorCodes.RETURN_CODE_SUCCESS) {
            //            String errorMessage2 = ZulUtils.i18nLabel("err." + this.returnCode);
            //            if (errorMessage2.equals("{err." + this.returnCode + "}")) {
            //                //errorMessage = this.returnMessage + " (" + this.returnCode + ")";
            //                errorMessage = this;
            //            } else {
            //                errorMessage = new ReturnCodeException(this.returnCode, ZulUtils.i18nLabel("err." + this.returnCode), null);
            //            }
            errorMessage = this;
        }
        return errorMessage;
    }

}
