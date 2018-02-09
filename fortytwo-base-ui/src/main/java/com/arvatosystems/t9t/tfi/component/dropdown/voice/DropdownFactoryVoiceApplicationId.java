package com.arvatosystems.t9t.tfi.component.dropdown.voice;

import com.arvatosystems.t9t.tfi.component.dropdown.Dropdown28Db;
import com.arvatosystems.t9t.tfi.component.dropdown.IDropdown28DbFactory;
import com.arvatosystems.t9t.base.search.LeanSearchRequest;
import com.arvatosystems.t9t.voice.VoiceApplicationDTO;
import com.arvatosystems.t9t.voice.VoiceApplicationKey;
import com.arvatosystems.t9t.voice.VoiceApplicationRef;
import com.arvatosystems.t9t.voice.request.LeanVoiceApplicationSearchRequest;

import de.jpaw.dp.Named;
import de.jpaw.dp.Singleton;

@Named("applicationId")
@Singleton
public class DropdownFactoryVoiceApplicationId  implements IDropdown28DbFactory<VoiceApplicationRef> {

    @Override
    public String getDropdownId() {
        return "applicationId";
    }

    @Override
    public Dropdown28Db<VoiceApplicationRef> createInstance() {
        return new Dropdown28Db<VoiceApplicationRef>(this);
    }

    @Override
    public LeanSearchRequest getSearchRequest() {
        return new LeanVoiceApplicationSearchRequest();
    }

    @Override
    public VoiceApplicationRef createRef(Long ref) {
        return new VoiceApplicationRef(ref);
    }

    @Override
    public VoiceApplicationRef createKey(String id) {
        return new VoiceApplicationKey(id);
    }

    @Override
    public String getIdFromKey(VoiceApplicationRef key) {
        if (key instanceof VoiceApplicationKey)
            return ((VoiceApplicationKey) key).getApplicationId();
        if (key instanceof VoiceApplicationDTO)
            return ((VoiceApplicationDTO) key).getApplicationId();
        return null;
    }

}
