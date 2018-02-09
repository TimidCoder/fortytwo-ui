package com.arvatosystems.t9t.tfi.component;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.SimpleListModel;

public class SimpleListModelExt<E> extends SimpleListModel<E> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleListModelExt.class);

    /**
     *
     */
    private static final long serialVersionUID = -848831378739903090L;

    public SimpleListModelExt(List<E> data) {
        super(data);
        LOGGER.debug("created SimpleListModelExt for {} entries", data.size());
    }

    @Override
    public ListModel<E> getSubModel(Object value, int nRows) {
        LOGGER.debug("getSubModel {} for {} rows", value, nRows);
        @SuppressWarnings("deprecation")
        final String idx = value == null ? "" : objectToString(value);
        if (nRows < 0)
            nRows = 10;
        final LinkedList<E> data = new LinkedList<E>();
        for (int i = 0; i < getSize(); i++) {
            if (idx.equals("") || entryMatchesText(getElementAt(i).toString(), idx)) {
                data.add(getElementAt(i));
                if (--nRows <= 0)
                    break; // done
            }
        }
        return new SimpleListModelExt<E>(data);
    }

    public boolean entryMatchesText(String entry, String text) {
        return entry.toLowerCase().startsWith(text.toLowerCase());
    }
}
