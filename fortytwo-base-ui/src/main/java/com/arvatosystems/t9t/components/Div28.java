package com.arvatosystems.t9t.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zul.Div;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.component.ext.IPermissionOwner;

import de.jpaw.bonaparte.pojos.api.auth.Permissionset;

public class Div28 extends Div implements IPermissionOwner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Div28.class);
    private static final long serialVersionUID = -8089438052410249L;

    private final ApplicationSession session = ApplicationSession.get();
    protected Permissionset permissions = Permissionset.of();
    private String gridId;

    public Div28() {
        super();
        LOGGER.debug("new Div28() created");
        setWidth("100%");
        setSclass("caption");
    }

    @Override
    public void setId(String id) {
        LOGGER.debug("Div28() assigned  ID {}", id);
        super.setId(id);
    }

    @Override
    public void setVflex(String flex) {
        super.setVflex(flex);
    }

    @Override
    public Permissionset getPermissions() {
        return permissions;
    }

    public String getGridId() {
        return gridId;
    }

    public void setGridId(String gridId) {
        this.gridId = gridId;
        permissions = session.getPermissions(gridId);
    }
}
