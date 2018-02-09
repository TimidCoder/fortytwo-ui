package com.arvatosystems.t9t.tfi.web;

import java.util.Collection;

import javax.servlet.ServletContext;

import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arvatosystems.t9t.tfi.web.shiro.CommonRealm;
import com.arvatosystems.t9t.tfi.web.shiro.DbRealm;

import de.jpaw.dp.Jdp;
import de.jpaw.dp.Singleton;

@Singleton
public class CdiWebEnvironmentLoaderListener extends EnvironmentLoaderListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(CdiWebEnvironmentLoaderListener.class);

    protected final CommonRealm commonRealm = Jdp.getRequired(CommonRealm.class);

    public CdiWebEnvironmentLoaderListener() {
        LOGGER.debug("CdiWebEnvironmentLoaderListener CONSTRUCTOR (web.xml)");
    }

    @Override
    protected WebEnvironment createEnvironment(ServletContext sc) {
        WebEnvironment environment = super.createEnvironment(sc);

        Collection<Realm> configuredRealms = ((RealmSecurityManager) environment.getSecurityManager()).getRealms();

        for (Realm realm : configuredRealms) {
            if (realm instanceof DbRealm) {
                DbRealm configuredDbRealm = (DbRealm) realm;
                configuredDbRealm.setCommonRealm(this.commonRealm);
            }
        }
        LOGGER.info("Creating shiro environment with {} realms.", configuredRealms.size());

        return environment;
    }
}
