package com.arvatosystems.t9t.tfi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.util.SessionCleanup;
import org.zkoss.zk.ui.util.SessionInit;

/**
 * Counting the Session/user.
 * @author INCI02
 */
public class SessionListener implements SessionInit, SessionCleanup {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);

    public SessionListener() {
        LOGGER.debug("SessionListener CONSTRUCTOR: [{}]", this.hashCode());
    }

    @Override
    public void cleanup(Session sess) throws Exception {
        LOGGER.debug("SessionListener cleanup: [{}]", this.hashCode());
        if (ApplicationSession.isSessionValid()) {
            ApplicationSession.get().setJwt(null);
        } else {
            LOGGER.debug("Shiro session is not longer valid. Skip cleanup");
        }
    }

    @Override
    public void init(Session sess, Object request) throws Exception {
        LOGGER.info("** SessionListener init()...");
    }
}
