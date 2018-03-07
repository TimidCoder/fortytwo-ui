package com.arvatosystems.t9t.tfi.viewmodel;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import com.arvatosystems.t9t.tfi.general.Constants;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;

public class ExpiredCredentialsViewModel28 extends ChangePwdViewModel28 {

    boolean pwdExpired = true;

    @Init
    @Override
    void init() {
        super.init();
        final ApplicationSession as = ApplicationSession.get();
        if (as != null && as.getPasswordExpires() != null && as.getPasswordExpires().isAfterNow()) {
            pwdExpired = false;
            postProcessHook();
        }
    }

    public boolean isPwdExpired() {
        return pwdExpired;
    }

    public void setPwdExpired(boolean pwdExpired) {
        this.pwdExpired = pwdExpired;
    }

    @Override
    public void postProcessHook() {
        Executions.getCurrent().sendRedirect(Constants.ZulFiles.LOGIN_TENANT_SELECTION);
    };
}
