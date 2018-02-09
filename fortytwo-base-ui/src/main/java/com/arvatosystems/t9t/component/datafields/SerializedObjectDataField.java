package com.arvatosystems.t9t.component.datafields;

import java.util.Map;

import org.zkoss.zul.Textbox;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.core.BonaparteJsonEscaper;
import de.jpaw.bonaparte.core.MapParser;
import de.jpaw.bonaparte.pojos.meta.ObjectReference;
import de.jpaw.json.JsonParser;

public class SerializedObjectDataField extends AbstractDataField<Textbox, BonaPortable> {
    protected final Textbox c = new Textbox();
    protected final ObjectReference myCfg;
    protected final String bonaparteType;

    @Override
    public boolean empty() {
        return c.getValue() == null || c.getValue().length() == 0;
    }

    public SerializedObjectDataField(DataFieldParameters params, String bonaparteType) {
        super(params);
        this.bonaparteType = bonaparteType;
        this.myCfg = (ObjectReference)params.cfg;
        c.setMultiline(true);
        setConstraints(c, null);
    }
    @Override
    public void clear() {
        c.setValue(null);
    }

    @Override
    public Textbox getComponent() {
        return c;
    }

    @Override
    public BonaPortable getValue() {
        if (empty())
            return null;
        // analyse JSON
        Map<String, Object> asMap = (new JsonParser(c.getValue(), false)).parseObject();
        return MapParser.asBonaPortable(asMap, myCfg);
    }

    @Override
    public void setValue(BonaPortable data) {
        c.setValue(BonaparteJsonEscaper.asJson(data));
    }
}
