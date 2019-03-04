package com.xformix.northwindstest.forms.startup;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.xformix.cuba.utils.CustomLookup;


public class StartupCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    com.haulmont.cuba.gui.components.Button OK;

    @Inject
    com.haulmont.cuba.gui.components.CheckBox HideStartupForm;

    @Override
    public void init(Map<String, Object> params) {



    }
}