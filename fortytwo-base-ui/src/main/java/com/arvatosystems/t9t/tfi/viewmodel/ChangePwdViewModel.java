package com.arvatosystems.t9t.tfi.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.WrongValueException;

import com.arvatosystems.t9t.tfi.services.IUserDAO;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.tfi.web.ZulUtils;

import de.jpaw.dp.Jdp;



/**
 * Reset the password if expired.
 * @author INCI02
 *
 */
public class ChangePwdViewModel {
    private boolean pwdExpired=false;
    private String retypePwd;
    private String newPwd;
    private String oldPwd;
    private ReturnCodeException errorMessage;
    private String confirmMessage;

    private final IUserDAO     userDAO = Jdp.getRequired(IUserDAO.class);

    public ChangePwdViewModel() {
    }


    /**
     * @return the pwdExpired
     */
    public final boolean isPwdExpired() {
        return pwdExpired;
    }

    /**
     * @param pwdExpired the pwdExpired to set
     */
    public final void setPwdExpired(boolean pwdExpired) {
        this.pwdExpired = pwdExpired;
    }

    /**
     * Saves the new entered password.
     */
    @NotifyChange({"errorMessage","confirmMessage"})
    @Command
    public final void saveData() {
        if (!newPwd.equals(retypePwd)) {
            throw new WrongValueException(com.arvatosystems.t9t.tfi.web.ZulUtils.i18nLabel("pwdexpired.match"));
        }
        try {
            userDAO.changePassword(getOldPwd(), getNewPwd());
        } catch (ReturnCodeException e) {
            this.errorMessage = e; //e.getReturnCodeMessage();
        }
        if (errorMessage == null) {
            setSuccessMessage(ZulUtils.i18nLabel("changepwd.success"));
        }
    }


    /**
     * Clear the error message on submitting the OK button.
     */
    @NotifyChange("errorMessage")
    @Command
    public final void okErrorMessage() {
        // clear the message
        errorMessage = null;
    }

    public final ReturnCodeException getErrorMessage() {
        return errorMessage;
    }

    public final String getConfirmMessage() {
        return confirmMessage;
    }
    @NotifyChange("confirmMessage")
    @Command
    public final void okConfirmMessage() {
        // clear the message
        confirmMessage = null;
    }
    @NotifyChange({"confirmMessage","retypePwd","newPwd","oldPwd"})
    public final void setSuccessMessage(String message) {
        this.confirmMessage=message;
        this.retypePwd=null;
        this.newPwd=null;
        this.oldPwd=null;
    }


    /**
     * @return the retypePwd
     */
    public final String getRetypePwd() {
        return retypePwd;
    }


    /**
     * @param retypePwd the retypePwd to set
     */
    @NotifyChange("retypePwd")
    public final void setRetypePwd(String retypePwd) {
        this.retypePwd = retypePwd;
    }


    /**
     * @return the newPwd
     */
    public final String getNewPwd() {
        return newPwd;
    }


    /**
     * @param newPwd the newPwd to set
     */
    @NotifyChange("newPwd")
    public final void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }


    /**
     * @return the oldPwd
     */
    public final String getOldPwd() {
        return oldPwd;
    }


    /**
     * @param oldPwd the oldPwd to set
     */
    @NotifyChange("oldPwd")
    public final void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }




}
