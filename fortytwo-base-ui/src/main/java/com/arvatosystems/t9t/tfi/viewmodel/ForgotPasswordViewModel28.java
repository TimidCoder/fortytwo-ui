package com.arvatosystems.t9t.tfi.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.arvatosystems.t9t.authc.api.ResetPasswordRequest;
import com.arvatosystems.t9t.components.crud.AbstractViewOnlyVM;
import com.arvatosystems.t9t.tfi.general.Constants;
import com.arvatosystems.t9t.tfi.services.IUserDAO;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.tfi.web.ZulUtils;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.dp.Jdp;

public class ForgotPasswordViewModel28 extends AbstractViewOnlyVM<ResetPasswordRequest, TrackingBase> {

    private final IUserDAO userDAO = Jdp.getRequired(IUserDAO.class);
    private final String ANONYMOUS_API_KEY = ZulUtils.i18nLabel("anonymous.apikey");

    @Init
    void init() {
        super.setInitial("resetPwd");
    }

    @NotifyChange("data")
    @Command
    public void saveData() throws ReturnCodeException {
        userDAO.getAuthenticationResponse(ANONYMOUS_API_KEY, null);
        userDAO.resetPassword(data.getUserId(), data.getEmailAddress());
        ApplicationSession.get().setJwt(null);
        postProcessHook();
    }

    public void postProcessHook() {
        Messagebox.show(ApplicationSession.get().translate("resetPwd", "success"), ApplicationSession.get().translate(null, "loginSubTitle"), Messagebox.OK, null,
                new EventListener<Event>() {
                    @Override
                    public void onEvent(Event event) throws Exception {
                        Executions.getCurrent().sendRedirect(Constants.ZulFiles.LOGIN);
                    }
                });
    }

    @Command
    @NotifyChange("data")
    public void reset() {
        clearData();
    }

}
