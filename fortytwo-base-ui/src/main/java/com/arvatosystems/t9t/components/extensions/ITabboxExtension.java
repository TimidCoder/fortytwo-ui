package com.arvatosystems.t9t.components.extensions;

import org.zkoss.zul.Tab;

import com.arvatosystems.t9t.components.Tabbox28;
import com.arvatosystems.t9t.components.Tabpanel28;

public interface ITabboxExtension {
    default void init(Tabbox28 box) {};
    default void afterRegisterPanel(Tabbox28 box, Tab tab, Tabpanel28 panel) {};
}
