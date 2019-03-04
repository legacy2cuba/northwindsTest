package com.xformix.northwindstest.forms.main_switchboard;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.xformix.cuba.utils.CustomLookup;


public class Main_switchboardCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    com.haulmont.cuba.gui.components.Button ExitMicrosoftAccess;

    @Inject
    com.haulmont.cuba.gui.components.Button DisplayDatabaseWindow;

    @Inject
    com.haulmont.cuba.gui.components.Button Sales_Reports_Dialog;

    @Inject
    com.haulmont.cuba.gui.components.Button Categories;

    @Inject
    com.haulmont.cuba.gui.components.Button Products;

    @Inject
    com.haulmont.cuba.gui.components.Button Suppliers;

    @Inject
    com.haulmont.cuba.gui.components.Button Orders;


    @Override
    public void init(Map<String, Object> params) {



    }
}