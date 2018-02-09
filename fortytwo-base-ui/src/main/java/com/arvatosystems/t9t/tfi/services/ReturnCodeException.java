package com.arvatosystems.t9t.tfi.services;

import com.arvatosystems.t9t.tfi.general.Constants;

@SuppressWarnings("serial")
public class ReturnCodeException extends Exception {

    private int returnCode =  Constants.ErrorCodes.RETURN_CODE_SUCCESS;
    private String returnMessage = null;
    private String errorDetails = null;

    public ReturnCodeException(int returnCode, String returnMessage, String errorDetails) {
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

    /**
     * Returns the tenant /local specific return code message.
     *
     * @return String .
     * */

    //    public final String getReturnCodeMessage() {
    //        String errorMessage = null;
    //        if (this.returnCode != Constants.ErrorCodes.RETURN_CODE_SUCCESS) {
    //            errorMessage = ZulUtils.i18nLabel("err." + this.returnCode);
    //            if (errorMessage.equals("{err." + this.returnCode + "}")) {
    //                errorMessage = this.returnMessage + " (" + this.returnCode + ")";
    //            }
    //        }
    //        return errorMessage;
    //    }


    //    public final String getReturnCodeMessage() {
    //        String errorMessage = null;
    //        if (this.returnCode != Constants.ErrorCodes.RETURN_CODE_SUCCESS) {
    //            errorMessage = ZulUtils.i18nLabel("err." + this.returnCode);
    //            if (errorMessage.equals("{err." +  this.returnCode +"}")) {
    //                errorMessage = this.returnMessage + " ("+this.returnCode+")";
    //            }
    //        }
    //        return errorMessage;
    //    }

    public final ReturnCodeException getReturnCodeMessage() {
        ReturnCodeException errorMessage = null;
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
