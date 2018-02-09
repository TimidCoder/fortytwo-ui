package com.arvatosystems.t9t.tfi.viewmodel.navigation;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zul.GroupsModelArray;

import com.arvatosystems.t9t.tfi.model.bean.Navi;

/**
 *
 * @author INCI02
 *
 */
public class NaviGroupingViewModel extends GroupsModelArray<Navi, String, String, Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NaviGroupingViewModel.class);


    private static final long serialVersionUID = 1L;
    private boolean showGroup;

    public NaviGroupingViewModel(List<Navi> data, Comparator<Navi> cmpr, boolean showGroup) {
        super(data.toArray(new Navi[0]), cmpr);
        closeGroup();
        this.showGroup = showGroup;
    }
    private  void closeGroup() {
        Navi navi=null;
        for (int i = 0; i < getGroupCount(); i++) {
            navi = getChild(i, 0);
            if (navi.isCloseGroup()) {
                removeOpenGroup(i);
            }
        }
    }

    @Override
    protected final String createGroupHead(Navi[] groupdata, int index, int col) {
        String ret = "";
        if (groupdata.length > 0) {
            ret = groupdata[0].getCategory();
        }

        return ret;
    }


    @Override
    public final boolean hasGroupfoot(int groupIndex) {
        boolean retBool = false;

        if (showGroup) {
            retBool = super.hasGroupfoot(groupIndex);
        }

        return retBool;
    }

    /**
     * refresh testing
     */
    @GlobalCommand("refresh")
    public final void refresh() {
        LOGGER.debug("refresh");
    }
}
