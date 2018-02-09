package com.arvatosystems.t9t.components;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;

public class ComponentTools28 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentTools28.class);

    /** Move all childs of a given component which are after a marker component as child
     * to a new parent. Returns the first such child.
     * This implementation uses a two phase approach, to avoid changing the live structure while we examine it.
     */
    public static Component moveChilds(Component currentParent, Component markerChild, Component newParent) {
        final List<Component> componentsToBeMoved = new ArrayList<Component>();

        // phase 0: simple plausi check
        if (currentParent == null || markerChild == null) {
            LOGGER.error("FATAL: Cannot move childs, components are null!");
            throw new NullPointerException();
        }
        // phase 1: find all suitable components
        boolean moving = false;
        for (Component c : currentParent.getChildren()) {
            if (moving)
                componentsToBeMoved.add(c);
            else
                if (c == markerChild)
                    moving = true;
        }
        if (!moving) {
            LOGGER.error("Marker component {} not found as a child of parent {} - programming error?",
                    markerChild.getClass().getCanonicalName(), currentParent.getClass().getCanonicalName());
            return null;
        }

        // phase 2: do the move...
        LOGGER.debug("Moving {} childs of {}", componentsToBeMoved.size(), currentParent.getClass().getSimpleName());
        if (componentsToBeMoved.isEmpty())
            return null;
        if (newParent != null) {
            // actual move, not just compute...
            for (Component c : componentsToBeMoved)
                c.setParent(newParent);
        }
        return componentsToBeMoved.get(0);
    }
}
