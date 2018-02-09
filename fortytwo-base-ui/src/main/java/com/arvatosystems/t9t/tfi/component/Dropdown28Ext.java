package com.arvatosystems.t9t.tfi.component;

import java.util.List;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Combobox;

public abstract class Dropdown28Ext extends Combobox {
    /**
     *
     */
    private static final long serialVersionUID = -4334311396799707798L;
    final List<String> modelData;
    final AbstractComponent self = this;

    protected Dropdown28Ext(List<String> initialModel) {
        super();
        this.setAutocomplete(true);
        this.setAutodrop(true);
        this.setHflex("1");
        this.setSclass("dropdown");
        this.modelData = initialModel;

        setModel(new SimpleListModelExt<String>(modelData));

        this.addEventListener(Events.ON_CHANGE, (event) -> {
            if (!modelData.contains(getValue())) {
                setRawValue("");  // clearing raw data is not always what we want, it kills the ability to search with LIKE criteria...
                setModel(new SimpleListModelExt<String>(modelData));
            }
        });
    }
}
