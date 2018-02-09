package com.arvatosystems.t9t.ui.tests;

import org.junit.Test;

import com.arvatosystems.t9t.jdp.Init;
import com.arvatosystems.t9t.translation.be.TranslationsStack;

public class UiTranslationsAlertOnDuplicatesTest {

    @Test
    public void alertOnDuplicateTranslationsTest() throws Exception {
        Init.initializeT9t();  // initialize
        final int numDuplicates = TranslationsStack.getNumberOfDuplicateTranslations();
        if (numDuplicates != 0) {
            System.out.println(numDuplicates + " overwritten translation entries exist - check logs for details");
            throw new Exception(numDuplicates + " duplicate translation entries exist");
        }
    }
}
