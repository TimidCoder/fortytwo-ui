package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.base.search.LeanSearchRequest;
import com.arvatosystems.t9t.doc.DocConfigDTO;
import com.arvatosystems.t9t.doc.DocConfigKey;
import com.arvatosystems.t9t.doc.DocConfigRef;
import com.arvatosystems.t9t.doc.request.LeanDocConfigSearchRequest;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("docConfigId")
@Singleton
public class Dropdown28FactoryDocConfig implements IDropdown28DbFactory<DocConfigRef> {

    @Override
    public String getDropdownId() {
        return "docConfigId";
    }

    @Override
    public LeanSearchRequest getSearchRequest() {
        return new LeanDocConfigSearchRequest();
    }

    @Override
    public DocConfigRef createRef(Long ref) {
        return new DocConfigRef(ref);
    }

    @Override
    public DocConfigRef createKey(String id) {
        return new DocConfigKey(id);
    }

    @Override
    public Dropdown28Db<DocConfigRef> createInstance() {
        return new Dropdown28Db<DocConfigRef>(this);
    }

    @Override
    public String getIdFromKey(DocConfigRef key) {
        if (key instanceof DocConfigKey)
            return ((DocConfigKey)key).getDocumentId();
        if (key instanceof DocConfigDTO)
            return ((DocConfigDTO)key).getDocumentId();
        return null;
    }
}
