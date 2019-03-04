package com.xformix.northwindstest.forms.customers;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.Customers ;

public class CustomersCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<Customers> customersDs ;

    @Inject
    com.haulmont.cuba.gui.components.TextField CustomerID;

    @Inject
    com.haulmont.cuba.gui.components.TextField CompanyName;

    @Inject
    com.haulmont.cuba.gui.components.TextField ContactName;

    @Inject
    com.haulmont.cuba.gui.components.TextField ContactTitle;

    @Inject
    com.haulmont.cuba.gui.components.TextArea Address;

    @Inject
    com.haulmont.cuba.gui.components.TextField City;

    @Inject
    com.haulmont.cuba.gui.components.TextField Region;

    @Inject
    com.haulmont.cuba.gui.components.TextField PostalCode;

    @Inject
    com.haulmont.cuba.gui.components.TextField Phone;

    @Inject
    com.haulmont.cuba.gui.components.TextField Fax;

    @Inject
    com.haulmont.cuba.gui.components.LookupField Country;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, customersDs);
        customersDs.addItemChangeListener(new Datasource.ItemChangeListener<Customers>() {
            @Override
            public void itemChanged(ItemChangeEvent<Customers> e) {


            }
        });


    }
}