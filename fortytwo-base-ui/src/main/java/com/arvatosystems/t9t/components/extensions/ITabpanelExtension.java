package com.arvatosystems.t9t.components.extensions;

import com.arvatosystems.t9t.components.Tabpanel28;

import de.jpaw.bonaparte.api.SearchFilters;

public interface ITabpanelExtension {
    default void init(Tabpanel28 box) {};
    default void onSelect(Tabpanel28 panel) {};
    default void beforeOnCreate(Tabpanel28 panel) {};
    default void afterOnCreate(Tabpanel28 panel) {
        // if no custom impl. set all the target grid to false
        if (panel != null && panel.getTargetGrid()!=null) {
           panel.getTargetGrid().setFilter2(SearchFilters.FALSE);
        }
    };
}
