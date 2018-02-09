package com.arvatosystems.t9t.component.ext;

import org.zkoss.zk.ui.Component;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;
import com.arvatosystems.t9t.base.CrudViewModel;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.api.TrackingBase;

/** Interface to add to custom components if they understand the concept of view models.
 * This is used to get the view model from parents.
 */
public interface IViewModelOwner extends Component {
    void setViewModelId(String viewModelId);
    String getViewModelId();
    CrudViewModel<BonaPortable, TrackingBase> getCrudViewModel();
    ApplicationSession getSession();
}
