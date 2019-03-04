package com.xformix.northwindstest.forms.products;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.Products ;

public class ProductsCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<Products> productsDs ;

    @Inject
    com.haulmont.cuba.gui.components.Button PreviewReport;

    @Inject
    com.haulmont.cuba.gui.components.Button OutputToHTML;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductID;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductName;

    @Inject
    com.haulmont.cuba.gui.components.TextField QuantityPerUnit;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitPrice;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitsInStock;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitsOnOrder;

    @Inject
    com.haulmont.cuba.gui.components.TextField ReorderLevel;

    @Inject
    com.haulmont.cuba.gui.components.CheckBox Discontinued;

    @Inject
    com.haulmont.cuba.gui.components.LookupField CategoryID;

    @Inject
    com.haulmont.cuba.gui.components.LookupField SupplierID;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, productsDs);
        productsDs.addItemChangeListener(new Datasource.ItemChangeListener<Products>() {
            @Override
            public void itemChanged(ItemChangeEvent<Products> e) {


            }
        });


    }
}