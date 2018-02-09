package com.arvatosystems.t9t.viewmodel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Window.Mode;

import com.arvatosystems.t9t.components.crud.ModuleConfigVM;
import com.arvatosystems.t9t.email.EmailModuleCfgDTO;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;

@Init(superclass = true)
public class SendTestEmail extends ModuleConfigVM<EmailModuleCfgDTO> {

    @Command
    public void popup() throws ReturnCodeException {
        Window modal = (Window) Executions.createComponents("/context/testEmail.zul", null, null);
        modal.setSizable(true);
        modal.setClosable(true);
        modal.setMode(Mode.MODAL);
        modal.setClientAttribute("noautofocus", "true");
    }
    

}

