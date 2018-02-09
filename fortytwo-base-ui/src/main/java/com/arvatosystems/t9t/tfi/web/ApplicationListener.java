package com.arvatosystems.t9t.tfi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppInit;
// import com.arvatosystems.t9t.init.InitContainers;

public class ApplicationListener implements WebAppInit {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);

    @Override
    public void init(WebApp arg0) throws Exception {
        // xenums done by prior init(), no more need to do it here...
        LOGGER.info("*******************************************************");
        LOGGER.info("** ApplicationListener init()...");
        LOGGER.info("*******************************************************");
        // InitContainers.initializeT9t();
    }
}
