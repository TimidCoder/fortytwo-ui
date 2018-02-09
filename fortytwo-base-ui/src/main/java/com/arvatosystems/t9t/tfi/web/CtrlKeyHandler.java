package com.arvatosystems.t9t.tfi.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.util.Clients;

import com.arvatosystems.t9t.tfi.general.ApplicationUtil;

public class CtrlKeyHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CtrlKeyHandler.class);

    public void ctrlKeyClick( KeyEvent keyEvent,  List<HtmlBasedComponent> htmlBasedComponents) {

        String keyCodeString = ApplicationUtil.getKeyCodeFromKeyEvent(keyEvent);
        LOGGER.debug("keyCodeString: " + keyCodeString);

        if (null != htmlBasedComponents && !htmlBasedComponents.isEmpty()) {
            if (keyCodeString.equals("C+E")) {
                htmlBasedComponents.get(0).setFocus(true);
            }
            for (int i = 0; i<htmlBasedComponents.size(); i++) {
                if (keyCodeString.equals("A+"+i) && htmlBasedComponents.size()>=(i+2)) {
                    htmlBasedComponents.get(i+1).setFocus(true);
                }
                if (keyCodeString.equals("C+M")) {
                    if (i < 11) {
                        if (i == 0) {
                            Clients.showNotification("C+E", null, htmlBasedComponents.get(i), "top_center", 2000);
                        } else {
                           Clients.showNotification("A+"+(i-1), null, htmlBasedComponents.get(i), "top_center", 2000);
                        }
                    }
                }
            }
        }
    }
}
