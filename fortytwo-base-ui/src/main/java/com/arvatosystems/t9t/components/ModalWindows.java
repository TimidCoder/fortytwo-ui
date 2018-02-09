package com.arvatosystems.t9t.components;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import de.jpaw.bonaparte.core.BonaPortable;

public class ModalWindows {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModalWindows.class);

    public static <T extends BonaPortable> Component runModal(
            final String zulFile,
            final Component parent,
            final T srcViewModel, boolean deepCopy,
            final Consumer<T> onOK) {

        final T viewModel = deepCopy ? (T) srcViewModel.ret$MutableClone(true, true) : srcViewModel;
        Map<String, Object> inst = new HashMap<String, Object>();
        inst.put("inst", viewModel);

        Component modal = Executions.createComponents(zulFile, parent, inst);
        if (onOK != null) {
            modal.addEventListener(Events.ON_OK, ev -> {
                LOGGER.debug("modal window OK: performing task");
                // perform some (blocking) code
                onOK.accept(viewModel);
                // then close the window
                LOGGER.debug("now closing modal window");
                Events.postEvent(new Event(Events.ON_CLOSE, modal, null));
            });
        }
        return modal;
    }
}
