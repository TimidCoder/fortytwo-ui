package com.arvatosystems.t9t.tfi.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dropdown28Country extends Dropdown28Ext {

    private static final List<String> countryModelData = new ArrayList<>();
    static {
        Stream<String> s = Arrays.stream(Locale.getISOCountries());
        countryModelData.add("XX");
        countryModelData.addAll(s.sorted().collect(Collectors.toList()));
    }

    /**
     *
     */
    private static final long serialVersionUID = 3911446278727438869L;

    public Dropdown28Country() {
        super(countryModelData);
        this.setMaxlength(2);
    }
}
