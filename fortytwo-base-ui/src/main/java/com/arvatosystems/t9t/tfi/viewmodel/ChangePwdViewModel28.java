package com.arvatosystems.t9t.tfi.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.WrongValueException;

import com.arvatosystems.t9t.base.auth.ChangePasswordUI;
import com.arvatosystems.t9t.components.crud.AbstractViewOnlyVM;
import com.arvatosystems.t9t.tfi.services.IUserDAO;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.dp.Jdp;

public class ChangePwdViewModel28 extends AbstractViewOnlyVM<ChangePasswordUI, TrackingBase> {

    private final IUserDAO userDAO = Jdp.getRequired(IUserDAO.class);

    @Init
    void init() {
        super.setInitial("changePwd");
    }

    @NotifyChange("data")
    @Command
    public void saveData() throws ReturnCodeException {

        if (!data.getNewPassword().equals(data.getRetypePassword())) {
            throw new WrongValueException(ApplicationSession.get().translate("changePwd", "password.mismatch"));
        }

        userDAO.changePassword(data.getOldPassword(), data.getNewPassword());
        postProcessHook();
    }

    public void postProcessHook() {
        Messagebox.show(ApplicationSession.get().translate("changePwd", "success"));
        reset();
    }

    @Command
    @NotifyChange("data")
    public void reset() {
        clearData();
    }

}
