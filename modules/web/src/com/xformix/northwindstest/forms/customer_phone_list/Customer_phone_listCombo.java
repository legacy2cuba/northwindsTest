package com.xformix.northwindstest.forms.customer_phone_list;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.Customers ;

public class Customer_phone_listCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<Customers> customersDs ;

    @Inject
    com.haulmont.cuba.gui.components.TextField ContactName;

    @Inject
    com.haulmont.cuba.gui.components.TextField Phone;

    @Inject
    com.haulmont.cuba.gui.components.TextField Fax;

    @Inject
    com.haulmont.cuba.gui.components.TextField CompanyName;

    @Inject
    com.haulmont.cuba.gui.components.TextField PageNumber;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout CompanyNameFilters;

    @Inject
    com.haulmont.cuba.gui.components.Button A;

    @Inject
    com.haulmont.cuba.gui.components.Button B;

    @Inject
    com.haulmont.cuba.gui.components.Button C;

    @Inject
    com.haulmont.cuba.gui.components.Button D;

    @Inject
    com.haulmont.cuba.gui.components.Button E;

    @Inject
    com.haulmont.cuba.gui.components.Button F;

    @Inject
    com.haulmont.cuba.gui.components.Button G;

    @Inject
    com.haulmont.cuba.gui.components.Button H;

    @Inject
    com.haulmont.cuba.gui.components.Button I;

    @Inject
    com.haulmont.cuba.gui.components.Button J;

    @Inject
    com.haulmont.cuba.gui.components.Button K;

    @Inject
    com.haulmont.cuba.gui.components.Button L;

    @Inject
    com.haulmont.cuba.gui.components.Button M;

    @Inject
    com.haulmont.cuba.gui.components.Button N;

    @Inject
    com.haulmont.cuba.gui.components.Button O;

    @Inject
    com.haulmont.cuba.gui.components.Button P;

    @Inject
    com.haulmont.cuba.gui.components.Button Q;

    @Inject
    com.haulmont.cuba.gui.components.Button R;

    @Inject
    com.haulmont.cuba.gui.components.Button S;

    @Inject
    com.haulmont.cuba.gui.components.Button T;

    @Inject
    com.haulmont.cuba.gui.components.Button U;

    @Inject
    com.haulmont.cuba.gui.components.Button V;

    @Inject
    com.haulmont.cuba.gui.components.Button W;

    @Inject
    com.haulmont.cuba.gui.components.Button X;

    @Inject
    com.haulmont.cuba.gui.components.Button Y;

    @Inject
    com.haulmont.cuba.gui.components.Button Z;

    @Inject
    com.haulmont.cuba.gui.components.Button All;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, customersDs);
        customersDs.addItemChangeListener(new Datasource.ItemChangeListener<Customers>() {
            @Override
            public void itemChanged(ItemChangeEvent<Customers> e) {

	        // PageNumber : Customers, \"Page \" & [Page];
	        setValue(PageNumber, "PageNumber",  "Page " +  getValue(customersDs, "page"));

	        // DatePrinted : Customers, Format(Date(),\"Medium Date\");
	        setValue(DatePrinted, "DatePrinted", Format( Date(  ),  "Medium Date" ));


            }
        });


    }
}