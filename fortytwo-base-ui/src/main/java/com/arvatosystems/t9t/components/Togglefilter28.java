package com.arvatosystems.t9t.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;

public class Togglefilter28 extends Tabbox {
    private static final long serialVersionUID = -821235703032080582L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Togglefilter28.class);

    @Wire("#stdTab")        protected Tab      stdTab;
    @Wire("#solrTab")       protected Tab      solrTab;
    @Wire("#stdPanel")      protected Tabpanel stdPanel;
    @Wire("#toggleButton2") protected Button28 toggleButton2;
    @Wire("#searchButton2") protected Button28 searchButton2;
    @Wire("#resetButton2")  protected Button28 resetButton2;
    @Wire("#solrText")      protected Textbox  solrText;

    Filter28 stdFilters;

    public Togglefilter28() {
        super();
        LOGGER.debug("new Togglefilter28() created");
        Executions.createComponents("/component/togglefilter28.zul", this, null);
        Selectors.wireComponents(this, this, false);
        resetButton2 .addEventListener(Events.ON_CLICK, ev -> solrText.setValue(null));
        toggleButton2.addEventListener(Events.ON_CLICK, ev -> showStd());
        searchButton2.addEventListener(Events.ON_CLICK, ev -> Events.postEvent("onSearch", this, solrText.getValue()));
        solrText     .addEventListener(Events.ON_OK,    ev -> Events.postEvent("onSearch", this, solrText.getValue()));
    }

    public void setStdFilter(Filter28 filters) {
        stdFilters = filters;
        stdFilters.setParent(stdPanel);
    }

    public void showSolr() {
        solrTab.setSelected(true);
    }
    public void showStd() {
        stdTab.setSelected(true);
    }
}
