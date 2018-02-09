package com.arvatosystems.t9t.tfi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.arvatosystems.t9t.tfi.model.bean.Navi;
import com.arvatosystems.t9t.tfi.viewmodel.navigation.NaviGroupingViewModel;
import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.dp.Singleton;

/**
 * Menu DAO builds up the Menu from the property file.
 *
 * @author INCI02
 *
 */
@Singleton
public class ApplicationDAO implements IApplicationDAO {

    /*************************************************************************************
     * MENU related
    *************************************************************************************/

    /*
     * (non-Javadoc)
     * @see com.arvatosystems.t9t.tfi.model.services.IApplicationDAO#
     * getNavigationByhierarchy(int)
     */
    @Override
    public final List<Navi> getNavigationByHierarchy(ApplicationSession as, int hierarchy) {
        List<Navi> somenavis = new ArrayList<Navi>();
        for (Iterator<Navi> i = as.getAllNavigations().iterator(); i.hasNext();) {
            Navi tmp = i.next();
            if (tmp.getHierarchy() == hierarchy) {
                somenavis.add(tmp);
            }
        }
        return somenavis;
    }

    @Override
    public final Navi getNavigationByLink(ApplicationSession as, String link) {
        Navi somenavis = null;
        for (Iterator<Navi> i = as.getAllNavigations().iterator(); i.hasNext();) {
            Navi tmp = i.next();
            if (tmp.getLink().equals(link)) {
                somenavis=tmp;
                return somenavis;
            }
        }
        return somenavis;
    }

    @Override
    public final Integer getGroupIndex(String link, NaviGroupingViewModel naviGroupingViewModel) {
        Integer  groupIndex = null;
        for (int groupIndexFlag=0; groupIndexFlag<naviGroupingViewModel.getGroupCount(); groupIndexFlag++) {
            int childCount=naviGroupingViewModel.getChildCount(groupIndexFlag);
            for (int childIndexFlag=0; childIndexFlag<childCount; childIndexFlag++) {
                Navi navi =naviGroupingViewModel.getChild(groupIndexFlag, childIndexFlag);
                if (navi.getLink().equals(link)) {
                    groupIndex=groupIndexFlag;
                    return groupIndex;
                }
            }

        }
        return groupIndex;
    }

    @Override
    public final Integer getGroupIndexByCategory(String category, NaviGroupingViewModel naviGroupingViewModel) {
        Integer  groupIndex = null;
        for (int groupIndexFlag=0; groupIndexFlag<naviGroupingViewModel.getGroupCount(); groupIndexFlag++) {
            int childCount=naviGroupingViewModel.getChildCount(groupIndexFlag);
            for (int childIndexFlag=0; childIndexFlag<childCount; childIndexFlag++) {
                Navi navi =naviGroupingViewModel.getChild(groupIndexFlag, childIndexFlag);
                if (navi.getCategory().equals(category)) {
                    groupIndex=groupIndexFlag;
                    return groupIndex;
                }
            }

        }
        return groupIndex;
    }
}
