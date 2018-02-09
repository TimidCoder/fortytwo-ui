package com.arvatosystems.t9t.tfi.viewmodel.navigation;

import java.io.Serializable;
import java.util.Comparator;
import org.zkoss.zul.GroupComparator;

import com.arvatosystems.t9t.tfi.model.bean.Navi;

/**
 * Menu related.
 * @author INCI02
 *
 */
public class NaviComparator implements Comparator<Navi>, GroupComparator<Navi>,
        Serializable {
    private static final long serialVersionUID = -5442923541968897269L;


    @Override
    public final int compare(Navi o1, Navi o2) {
        return o1.getCategory().compareTo(o2.getCategory().toString());
    }

    @Override
    public final int compareGroup(Navi o1, Navi o2) {
        if (o1.getCategory().equals(o2.getCategory())) {
            return 0;
        }
        else{
            return 1;
        }
    }

}
