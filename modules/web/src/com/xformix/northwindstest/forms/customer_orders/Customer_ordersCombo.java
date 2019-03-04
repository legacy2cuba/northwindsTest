package com.xformix.northwindstest.forms.customer_orders;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.Customers ;
import com.xformix.northwindstest.entity.OrderDetailsExtended ;
import com.xformix.northwindstest.entity.Orders ;

public class Customer_ordersCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<Customers> customersDs ;

    @Inject
    Datasource<Orders> ordersDs ;

    @Inject
    Datasource<OrderDetailsExtended> orderdetailsextendedDs ;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrderID;

    @Inject
    com.haulmont.cuba.gui.components.DateField OrderDate;

    @Inject
    com.haulmont.cuba.gui.components.DateField RequiredDate;

    @Inject
    com.haulmont.cuba.gui.components.DateField ShippedDate;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductName;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitPrice;

    @Inject
    com.haulmont.cuba.gui.components.TextField Quantity;

    @Inject
    com.haulmont.cuba.gui.components.TextField Discount;

    @Inject
    com.haulmont.cuba.gui.components.TextField ExtendedPrice;

    @Inject
    com.haulmont.cuba.gui.components.TextField CompanyName;

    @Inject
    com.haulmont.cuba.gui.components.TextField Country;

    @Inject
    com.haulmont.cuba.gui.components.Frame Customer_Orders_Subform1;

    @Inject
    com.haulmont.cuba.gui.components.Frame Customer_Orders_Subform2;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, customersDs);
        customersDs.addItemChangeListener(new Datasource.ItemChangeListener<Customers>() {
            @Override
            public void itemChanged(ItemChangeEvent<Customers> e) {


            }
        });

        ordersDs.addItemChangeListener(new Datasource.ItemChangeListener<Orders>() {
            @Override
            public void itemChanged(ItemChangeEvent<Orders> e) {


            }
        });


    }
}