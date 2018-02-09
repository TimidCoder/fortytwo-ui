package com.arvatosystems.t9t.tfi.web;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import com.arvatosystems.t9t.tfi.general.Constants;


/**
 *         This is a class which catches the initialization of a ZK page and
 *         redirects accordingly if no user credentials are found
 */
public class WorkbenchInit implements Initiator {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkbenchInit.class);


    /**
     * Invoked when the ZK Parser starts.
     * @param page Page
     * @param arg Map
     * @throws Exception
     */
    @Override
    public final void doInit(Page page, @SuppressWarnings("rawtypes") Map arg) throws Exception {
        String pagename = (String)arg.get("pagename");
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            LOGGER.info("User is not authenticated, redirecting to login...");
            Executions.getCurrent().sendRedirect(Constants.ZulFiles.LOGIN);
        }
        if (pagename == null) {
            LOGGER.info("No current pagename, redirecting to home...");
            Executions.getCurrent().sendRedirect(Constants.ZulFiles.HOME);
        }
    }

    /**
     *
     * @param parsingError .
     * @return boolean
     * @throws Exception .
     */
    public final boolean doCatch(Throwable parsingError) throws Exception {
        return false;
    }

    /**
     *
     * @param page .
     * @throws Exception .
     */
    public void doAfterCompose(Page page) throws Exception {}

    /**
     *
     * @throws Exception .
     */
    public void doFinally() throws Exception { }

}
