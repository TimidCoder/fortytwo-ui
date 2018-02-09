package com.arvatosystems.t9t.tfi.component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

public class Dropdown28Currency extends Dropdown28Ext {

    private static final long serialVersionUID = 7804881425211020003L;

    private static final List<String> currencyModelData = new ArrayList<>();
    static {
        currencyModelData.addAll(
                Currency.getAvailableCurrencies().stream().sorted(Comparator.comparing(Currency::getCurrencyCode))
                .map(Currency::getCurrencyCode).collect(Collectors.toList()));
    }

    public Dropdown28Currency() {
        super(currencyModelData);
        this.setMaxlength(3);
    }
}
