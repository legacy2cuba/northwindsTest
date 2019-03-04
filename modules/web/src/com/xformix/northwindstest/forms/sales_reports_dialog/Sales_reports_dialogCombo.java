package com.xformix.northwindstest.forms.sales_reports_dialog;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.xformix.cuba.utils.CustomLookup;


public class Sales_reports_dialogCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    com.haulmont.cuba.gui.components.Button Preview;

    @Inject
    com.haulmont.cuba.gui.components.Button Print;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportToPrint;

    @Inject
    com.haulmont.cuba.gui.components.Button EmployeeSalesByCountry;

    @Inject
    com.haulmont.cuba.gui.components.Button SalesSummaries;

    @Inject
    com.haulmont.cuba.gui.components.Button SalesByCategory;

    @Inject
    com.haulmont.cuba.gui.components.Button Cancel;

    @Override
    public void init(Map<String, Object> params) {



    }
}