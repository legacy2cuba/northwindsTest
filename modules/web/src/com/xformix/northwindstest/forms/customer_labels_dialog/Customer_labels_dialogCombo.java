package com.xformix.northwindstest.forms.customer_labels_dialog;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.gui.components.Table;
import com.xformix.cuba.utils.CustomLookup;


public class Customer_labels_dialogCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PrintLabelsFor;

    @Inject
    com.haulmont.cuba.gui.components.Button AllCountries;

    @Inject
    com.haulmont.cuba.gui.components.Button SpecificCountry;

    @Inject
    com.haulmont.cuba.gui.components.LookupField SelectCountry;

    @Inject
    com.haulmont.cuba.gui.components.Button Preview;

    @Inject
    com.haulmont.cuba.gui.components.Button Print;

    @Inject
    com.haulmont.cuba.gui.components.Button Cancel;


    @Override
    public void init(Map<String, Object> params) {



    }
}