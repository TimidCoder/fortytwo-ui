package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.tfi.services.IUserDAO;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.auth.PermissionsDTO;
import com.arvatosystems.t9t.auth.UserDTO;
import com.arvatosystems.t9t.auth.UserRef;
import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;

import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Jdp;

@Init(superclass = true)
public class UserVM extends CrudSurrogateKeyVM<UserRef, UserDTO, FullTrackingWithVersion> {

    protected IUserDAO userDAO = Jdp.getRequired(IUserDAO.class);

    @Override
    protected void clearData() {
        super.clearData();
        if (data.getPermissions() == null)
            data.setPermissions(new PermissionsDTO());
    }

    @Override
    protected void loadData(DataWithTracking<UserDTO, FullTrackingWithVersion> dwt) {
        super.loadData(dwt);
        if (data.getPermissions() == null)
            data.setPermissions(new PermissionsDTO());
    }

    @Command
    public void resetPassword() throws ReturnCodeException {
        if (data.getUserId() != null && data.getEmailAddress() != null)
            userDAO.resetPassword(data.getUserId(), data.getEmailAddress());
    }
}
