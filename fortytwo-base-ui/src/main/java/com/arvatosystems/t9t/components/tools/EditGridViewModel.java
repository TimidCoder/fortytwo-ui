/*
 * Copyright (c) 2012 - 2018 Arvato Systems GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arvatosystems.t9t.components.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.Pair;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

import com.arvatosystems.t9t.base.IGridConfigContainer;
import com.arvatosystems.t9t.base.uiprefs.UIGridPreferences;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.ui.UIColumnConfiguration;
import de.jpaw.bonaparte.pojos.ui.UIMeta;

public class EditGridViewModel {

    protected Listbox editGridListBox;
    private Window windowComponent = null;
    private List<String> currentGrid = null;
    private Pair<List<String>, List<String>> addRemovePair = null;
    private final ApplicationSession session = ApplicationSession.get();
    private List<UIColumnConfiguration> columns = null;

    @Wire("#editListBox")
    Listbox listbox;

    @SuppressWarnings("unchecked")
    @Init(superclass = true)
    public void init(@BindingParam("initParams") HashMap<String, Object> initParams,
            @ContextParam(ContextType.COMPONENT) Component component) {

        windowComponent = (Window) component.getRoot();
        if (initParams != null && initParams.get("gridId") != null) {
            UIGridPreferences uiGridPreferences = IGridConfigContainer.GRID_CONFIG_REGISTRY
                    .get(initParams.get("gridId"));
            Set<String> objectsToExclude = new HashSet<>();
            columns = new ArrayList<>(uiGridPreferences.getColumns().size());
            for (UIColumnConfiguration column : uiGridPreferences.getColumns()) {
                if (column.getFieldName().contains("orderItems")) {
                    columns.size();
                }

                if (isColumnAllowed(column, objectsToExclude)) {
                    columns.add(column);
                }
            }

            if (initParams.get("currentGridList") != null) {
                currentGrid = new ArrayList<>((List<String>) initParams.get("currentGridList"));
            }
        }
    }

    /**
     * To determine whether the column allowed for user to use on the grid
     * @param column
     * @param objectsToExclude
     * @return
     */
    private boolean isColumnAllowed(UIColumnConfiguration column, Set<String> objectsToExclude) {
        // exclude those are a list and it is not dynGrid
        for (String s : objectsToExclude) {
            if (column.getFieldName().startsWith(s)) {
                return false;
            }
        }

        UIMeta meta = column.getMeta();
        boolean isList = meta.getIsList() == null ? false : meta.getIsList();

        // exclude column that has no meta and dataCategory == OBJECT to avoid invalid
        // columns being rendered in the grid
        if (meta == null || meta.getDataCategory().equals("OBJECT")) {
            if (isList && !isDynField(meta)) {
                objectsToExclude.add(column.getFieldName());
            }
            return false;
        }

        return true;
    }

    /**
     * Convenient method to check if the meta contain of dynGrid property.
     *
     * @param meta
     * @return
     */
    public boolean isDynField(UIMeta meta) {
        final Map<String, String> props = meta.getFieldProperties();
        return props != null && props.get("dynGrid") != null;
    }

    @Command
    public void closeWindow() {
        Events.sendEvent("onClose", windowComponent, addRemovePair);
        windowComponent.onClose();
    }

    @Command
    public void updateGrid() {
        List<Listitem> selectedItems = listbox.getItems();
        List<String> addPair = new ArrayList<>();
        List<String> removePair = new ArrayList<>();

        if (listbox.getSelectedCount() == 0) {
            Messagebox.show(session.translate("editGrid", "selectedFieldCountZero"));
            return;
        }

        for (Listitem listItem : selectedItems) {
            UIColumnConfiguration uiColumnConfiguration = columns.get(listItem.getIndex());

            if (listItem.isSelected()) {
                if (!currentGrid.contains(uiColumnConfiguration.getFieldName())) {
                    addPair.add(uiColumnConfiguration.getFieldName());
                }
            } else {
                if (currentGrid.contains(uiColumnConfiguration.getFieldName())) {
                    removePair.add(uiColumnConfiguration.getFieldName());
                }
            }
        }

        addRemovePair = new Pair<List<String>, List<String>>(addPair, removePair);
        closeWindow();
    }

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);

        List<String> allAvailableFieldNames = new LinkedList<>();
        columns.stream().forEach(uiColumns->{allAvailableFieldNames.add(uiColumns.getFieldName());});
        listbox.setItemRenderer(new ListitemRenderer<String>() {
            @Override
            public void render(Listitem item, String data, int index) throws Exception {
                item.setValue(data);
                item.setLabel(data);
            }
        });
        ListModel<String> models = new ListModelList<>(allAvailableFieldNames,false);
        listbox.setModel(models);
        listbox.setCheckmark(true);
        listbox.setMultiple(true);
        listbox.renderAll();

        listbox.getItems().stream().forEach(item->{
            if (currentGrid.contains(item.getLabel())) {
                item.setSelected(true);
            }
        });
    }


}
