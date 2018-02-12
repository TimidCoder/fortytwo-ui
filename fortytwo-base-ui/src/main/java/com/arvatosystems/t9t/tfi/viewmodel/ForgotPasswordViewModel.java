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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import com.arvatosystems.t9t.tfi.general.Constants;
import com.arvatosystems.t9t.tfi.services.IUserDAO;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.tfi.web.ZulUtils;

import de.jpaw.dp.Jdp;

/**
 * Reset the password if expired.
 *
 * @author INCI02
 *
 */
public class ForgotPasswordViewModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordViewModel.class);

    private String user;
    private String email;
    private ReturnCodeException errorMessage;
    private String confirmMessage;

    private final IUserDAO     userDAO = Jdp.getRequired(IUserDAO.class);
    private final String ANONYMOUS_API_KEY= ZulUtils.i18nLabel("anonymous.apikey");
    @NotifyChange({ "errorMessage", "confirmMessage" })
    @Command
    public final void requestNewPassword() {
        try {
            userDAO.getAuthenticationResponse(ANONYMOUS_API_KEY, null);
            userDAO.resetPassword(user, email);
            ApplicationSession.get().setJwt(null);
        } catch (ReturnCodeException e) {
            this.errorMessage = e.getReturnCodeMessage();
            ApplicationSession.get().setJwt(null);
        }
        if (errorMessage == null) {
            setSuccessMessage(ZulUtils.i18nLabel("forgotpw.new.email.response"));
        }
    }

    public final String getConfirmMessage() {
        return confirmMessage;
    }

    @NotifyChange("confirmMessage")
    @Command
    public final void okConfirmMessage() {
        // clear the message
        confirmMessage = null;
        Executions.getCurrent().sendRedirect(Constants.ZulFiles.LOGIN);
    }

    @NotifyChange({ "confirmMessage", "user", "email" })
    public final void setSuccessMessage(String message) {
        this.confirmMessage = message;
        this.user = null;
        this.email = null;
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

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
