package com.xformix.northwindstest.forms.suppliers;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.Suppliers ;

public class SuppliersCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<Suppliers> suppliersDs ;

    @Inject
    com.haulmont.cuba.gui.components.TextField SupplierID;

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
    com.haulmont.cuba.gui.components.TextField Country;

    @Inject
    com.haulmont.cuba.gui.components.TextField Phone;

    @Inject
    com.haulmont.cuba.gui.components.TextField Fax;

    @Inject
    com.haulmont.cuba.gui.components.TextField HomePage;

    @Inject
    com.haulmont.cuba.gui.components.Button ReviewProducts;

    @Inject
    com.haulmont.cuba.gui.components.Button AddProducts;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, suppliersDs);
        suppliersDs.addItemChangeListener(new Datasource.ItemChangeListener<Suppliers>() {
            @Override
            public void itemChanged(ItemChangeEvent<Suppliers> e) {


            }
        });


    }
}