package com.arvatosystems.t9t.tfi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WebApp;

// UNUSED
@Deprecated
public class ApplicationScope {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationScope.class);

    private static final String APP_SCOPE = "APP_SCOPE";
    private static Object lock = new Object();

    private ApplicationScope() {

    }

    public static ApplicationScope get() {
        final Execution exec = Executions.getCurrent();
        if (exec != null) {
            final WebApp app = exec.getDesktop().getWebApp();
            ApplicationScope appScope = (ApplicationScope) app.getAttribute(APP_SCOPE);
            if (appScope == null) {
                synchronized (lock) {
                    if (appScope == null) {
                        app.setAttribute(APP_SCOPE, appScope = new ApplicationScope());
                    }
                }
            }
            return appScope;
        }
        throw new IllegalStateException("Unable to get/create application scope");
    }
}
