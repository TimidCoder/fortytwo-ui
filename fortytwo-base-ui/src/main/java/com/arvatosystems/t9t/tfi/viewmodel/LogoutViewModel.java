package com.arvatosystems.t9t.tfi.viewmodel;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import com.arvatosystems.t9t.tfi.general.Constants;

/**
 * Logout ViewModel.
 *
 * @author INCI02
 *
 */
public class LogoutViewModel extends GenericForwardComposer<Component> {
    private static final long serialVersionUID = -3398694299050788517L;

    public LogoutViewModel() {}

    /**
     *
     * @param comp clicked label / link
     * @throws Exception .
     */
    @Override
    public final void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
    }

    /**
     * On link clicked Shiro logoff.
     */
    @GlobalCommand("logoff")
    public final void onClick$logoff() {
        Executions.sendRedirect(Constants.ZulFiles.LOGOUT);
    }
}
