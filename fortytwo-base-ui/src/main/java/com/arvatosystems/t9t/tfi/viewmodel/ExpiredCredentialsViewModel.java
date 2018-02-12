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
package com.arvatosystems.t9t.tfi.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;

import com.arvatosystems.t9t.tfi.general.Constants;
import com.arvatosystems.t9t.tfi.services.IUserDAO;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.tfi.web.ZulUtils;

import de.jpaw.dp.Jdp;



/**
 * Reset the password if expired.
 * @author INCI02
 *
 */
public class ExpiredCredentialsViewModel {


    private boolean pwdExpired=false;
    private String retypePwd;
    private String newPwd;
    private String oldPwd;
    private ReturnCodeException errorMessage;

    private final IUserDAO     userDAO = Jdp.getRequired(IUserDAO.class);

    public ExpiredCredentialsViewModel() {
        //Check ONLY FOR INTERN DB USER
        checkExpired();
    }

    /**
     * If password not expired than redirect to the next screen (tenant/mandate) otherwise let the user enter the new password.
     */
    public final void checkExpired() {
        // TODO
//        if (authenticationDetails != null) { // must be check, in case of LDAP authentification
//            pwdExpired = LocalDateTime.now().toDate().getTime() >= authenticationDetails.getPasswordExpires().toDate().getTime();
//        }
        //pwdExpired=true;
        if (!pwdExpired) {
            Executions.getCurrent().sendRedirect(Constants.ZulFiles.LOGIN_TENANT_SELECTION);
        }
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
    @NotifyChange("errorMessage")
    @Command
    public final void saveData() {
        if (!newPwd.equals(retypePwd)) { throw new WrongValueException(ZulUtils.i18nLabel("pwdexpired.match")); }
        try {
            userDAO.changePassword(getOldPwd(), getNewPwd());
        } catch (ReturnCodeException e) {
            //this.errorMessage = ZulUtils.i18nDefaultLabel("err." + e.getReturnCode(), "err." + Constants.ErrorCodes.AUTHENTICATION_EXCEPTION);
            this.errorMessage = e.getReturnCodeMessage();
        }
        if (errorMessage == null) {
            Executions.getCurrent().sendRedirect(Constants.ZulFiles.LOGIN_TENANT_SELECTION);
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

    //    /**
    //     *
    //     * @return String ReturnCodeMessage.
    //     */
    //    public final String getReturnCodeMessage() {
    //        errorMessage=null;
    //        return errorMessage;
    //    }


    /**
     * @return the retypePwd
     */
    public final String getRetypePwd() {
        return retypePwd;
    }


    /**
     * @param retypePwd the retypePwd to set
     */
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
    public final void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }




}
