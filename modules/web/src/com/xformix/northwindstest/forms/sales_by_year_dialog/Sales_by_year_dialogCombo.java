package com.xformix.northwindstest.forms.sales_by_year_dialog;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.xformix.cuba.utils.CustomLookup;


public class Sales_by_year_dialogCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    com.haulmont.cuba.gui.components.TextField BeginningDate;

    @Inject
    com.haulmont.cuba.gui.components.TextField EndingDate;

    @Inject
    com.haulmont.cuba.gui.components.CheckBox ShowDetails;

    @Inject
    com.haulmont.cuba.gui.components.Button OK;

    @Inject
    com.haulmont.cuba.gui.components.Button Cancel;
    
    @Override
    public void init(Map<String, Object> params) {



    }
}