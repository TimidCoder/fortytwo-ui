package com.arvatosystems.t9t.tfi.component.dropdown;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.zkoss.zul.Combobox;

public class Dropdown28Registry {
    // static fields and methods
    private static final Map<String, IDropdown28BasicFactory<Combobox>> registry = new ConcurrentHashMap<String, IDropdown28BasicFactory<Combobox>>(50);

    /** Registers a new factory so that it can be retrieved by its ID. */
    public static void register(IDropdown28BasicFactory<Combobox> factory) {
        registry.put(factory.getDropdownId(), factory);
    }

    /** Returns the dropdown factory of the given type, or throw an Exception if none has been registered for the specified name. */
    public static final IDropdown28BasicFactory<Combobox> requireFactoryById(String dropdownId) {
        IDropdown28BasicFactory<Combobox> factory = registry.get(dropdownId);
        if (factory == null)
            throw new RuntimeException("no dropdown of ID " + dropdownId + " registered");
        return factory;
    }

    /** Factory method: get a dropdown of the specified ID. */
    public static final Combobox getDropdownById(String dropdownId) {
        return requireFactoryById(dropdownId).createInstance();
    }

    /** Returns the dropdown factory of the given type, or null if none has been registered for the specified name. */
    public static final IDropdown28BasicFactory getFactoryById(String dropdownId) {
        return registry.get(dropdownId);
    }
}
