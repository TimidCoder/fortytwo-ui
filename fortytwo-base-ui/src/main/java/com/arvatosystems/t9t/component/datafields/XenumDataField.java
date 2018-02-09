package com.arvatosystems.t9t.component.datafields;

import java.util.List;

import org.zkoss.zk.ui.event.Events;

import de.jpaw.bonaparte.enums.BonaEnum;
import de.jpaw.bonaparte.pojos.meta.XEnumDataItem;
import de.jpaw.bonaparte.pojos.meta.XEnumDefinition;
import de.jpaw.enums.AbstractXEnumBase;
import de.jpaw.enums.XEnumFactory;

public class XenumDataField extends AbstractEnumDataField<AbstractXEnumBase<?>> {
    protected final XEnumDefinition xed;

    private final void createModel() {
        XEnumFactory<?> factory = XEnumFactory.getFactoryByPQON(xed.getName());
        cbItems.clear();
        @SuppressWarnings("unchecked")
        List<AbstractXEnumBase<?>> instances = (List<AbstractXEnumBase<?>>) factory.valuesAsList();
        for (AbstractXEnumBase<?> e: instances) {
            if (enumRestrictions == null || enumRestrictions.contains(e.name()))
                newComboItem(e, as.translateEnum((BonaEnum)e.getBaseEnum()));
        }
    }

    public XenumDataField(DataFieldParameters params, String enumDtoRestriction) {
        super(params, ((XEnumDataItem)params.cfg).getBaseXEnum().getName(), enumDtoRestriction);
        xed = ((XEnumDataItem)cfg).getBaseXEnum();
        setConstraints(c, null);
        createModel();
        // combobox does not generate onChange events, in order to update the viewmodel, onSelect must be mapped to it
        c.addEventListener(Events.ON_SELECT, (ev) -> Events.postEvent(Events.ON_CHANGE, c, null));
    }
}
