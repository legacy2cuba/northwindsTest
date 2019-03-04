package com.xformix.northwindstest.forms.categories;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.Categories ;
import com.xformix.northwindstest.entity.Products ;

public class CategoriesCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<Categories> categoriesDs ;

    @Inject
    Datasource<Products> productsDs ;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductName;

    @Inject
    com.haulmont.cuba.gui.components.TextField QuantityPerUnit;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitPrice;

    @Inject
    com.haulmont.cuba.gui.components.CheckBox Discontinued;

    @Inject
    com.haulmont.cuba.gui.components.TextField CategoryName;

    @Inject
    com.haulmont.cuba.gui.components.TextArea Description;

    @Inject
    com.haulmont.cuba.gui.components.Frame Product_List;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, categoriesDs);
        categoriesDs.addItemChangeListener(new Datasource.ItemChangeListener<Categories>() {
            @Override
            public void itemChanged(ItemChangeEvent<Categories> e) {


            }
        });

        productsDs.addItemChangeListener(new Datasource.ItemChangeListener<Products>() {
            @Override
            public void itemChanged(ItemChangeEvent<Products> e) {


            }
        });


    }
}