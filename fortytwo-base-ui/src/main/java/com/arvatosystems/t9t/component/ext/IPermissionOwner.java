package com.arvatosystems.t9t.component.ext;

import org.zkoss.zk.ui.Component;

import de.jpaw.bonaparte.pojos.api.auth.Permissionset;

public interface IPermissionOwner extends Component {
    Permissionset getPermissions();
}
