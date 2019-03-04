package com.xformix.northwindstest.forms.sales_analysis;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.xformix.cuba.utils.CustomLookup;


public class Sales_analysisCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    com.haulmont.cuba.gui.components.Button btnEdit;

    @Override
    public void init(Map<String, Object> params) {



    }
}