package com.arvatosystems.t9t.tfi.services;

import java.util.List;

import com.arvatosystems.t9t.tfi.model.bean.Navi;
import com.arvatosystems.t9t.tfi.viewmodel.navigation.NaviGroupingViewModel;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;

public interface IApplicationDAO {

    /**
     *Returns all MenuItems by hierarchy.
     * @param hierarchy .
     * @return List<Navi>
     */
    public abstract List<Navi> getNavigationByHierarchy(ApplicationSession as, int hierarchy);

    public abstract Navi getNavigationByLink(ApplicationSession as, String link);
    public abstract Integer getGroupIndex(String link, NaviGroupingViewModel naviGroupingViewModel);
    public abstract Integer getGroupIndexByCategory(String category, NaviGroupingViewModel naviGroupingViewModel);

}
