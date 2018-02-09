package com.arvatosystems.t9t.components.grid;

import com.arvatosystems.t9t.bpmn.ProcessExecutionStatusDTO;

import de.jpaw.bonaparte.api.SearchFilters;
import de.jpaw.bonaparte.pojos.api.LongFilter;
import de.jpaw.bonaparte.pojos.api.SearchFilter;
import de.jpaw.bonaparte.pojos.api.TrackingBase;
import de.jpaw.bonaparte.pojos.api.UnicodeFilter;
import de.jpaw.bonaparte.pojos.api.DataWithTracking;
import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Singleton
@Named("bpmnStatus")
public class BpmnStatusKeyFromDataProvider implements IKeyFromDataProvider<ProcessExecutionStatusDTO, TrackingBase> {

    @Override
    public SearchFilter getFilterForKey(DataWithTracking<ProcessExecutionStatusDTO, TrackingBase> dwt) {
        final LongFilter targetFilter = new LongFilter("targetObjectRef");
        targetFilter.setEqualsValue(dwt.getData().getTargetObjectRef());

        final UnicodeFilter processIdFilter = new UnicodeFilter("processDefinitionId");
        processIdFilter.setEqualsValue(dwt.getData().getProcessDefinitionId());

        return SearchFilters.and(targetFilter, processIdFilter);
    }
}
