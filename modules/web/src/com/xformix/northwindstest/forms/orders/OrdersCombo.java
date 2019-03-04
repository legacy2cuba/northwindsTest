package com.xformix.northwindstest.forms.orders;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.haulmont.cuba.gui.data.impl.ValueGroupDatasourceImpl;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.OrderDetailsExtended ;
import com.xformix.northwindstest.entity.OrdersQry ;

public class OrdersCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<OrdersQry> ordersqryDs ;

    @Inject
    Datasource<OrderDetailsExtended> orderdetailsextendedDs ;

    @Inject
    ValueGroupDatasourceImpl sumextendedpriceDs;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitPrice;

    @Inject
    com.haulmont.cuba.gui.components.TextField Quantity;

    @Inject
    com.haulmont.cuba.gui.components.TextField Discount;

    @Inject
    com.haulmont.cuba.gui.components.TextField ExtendedPrice;

    @Inject
    com.haulmont.cuba.gui.components.LookupField ProductID;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrderSubtotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrderID;

    @Inject
    com.haulmont.cuba.gui.components.LookupField CustomerID;

    @Inject
    com.haulmont.cuba.gui.components.LookupField EmployeeID;

    @Inject
    com.haulmont.cuba.gui.components.DateField OrderDate;

    @Inject
    com.haulmont.cuba.gui.components.DateField RequiredDate;

    @Inject
    com.haulmont.cuba.gui.components.DateField ShippedDate;

    @Inject
    com.haulmont.cuba.gui.components.TextField Freight;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipName;

    @Inject
    com.haulmont.cuba.gui.components.TextArea ShipAddress;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipCity;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipRegion;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipPostalCode;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipCountry;

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
    com.haulmont.cuba.gui.components.Frame Orders_Subform;

    @Inject
    com.haulmont.cuba.gui.components.OptionsGroup ShipVia;

    @Inject
    com.haulmont.cuba.gui.components.CheckBox Federal;

    @Inject
    com.haulmont.cuba.gui.components.CheckBox Speedy;

    @Inject
    com.haulmont.cuba.gui.components.CheckBox United;

    @Inject
    com.haulmont.cuba.gui.components.TextField Subtotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField Total;

    @Inject
    com.haulmont.cuba.gui.components.Button PrintInvoice;

    @Inject
    com.haulmont.cuba.gui.components.Button DisplayProducts;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, ordersqryDs);
        ordersqryDs.addItemChangeListener(new Datasource.ItemChangeListener<OrdersQry>() {
            @Override
            public void itemChanged(ItemChangeEvent<OrdersQry> e) {

	        // OrderSubtotal : OrderDetailsExtended, Sum([ExtendedPrice]);
	        setValue(OrderSubtotal, "OrderSubtotal", getValue(sumextendedpriceDs, "sumextendedprice"));

	        // Subtotal : OrdersQry, [Orders Subform].Form![OrderSubtotal];
	        setValue(Subtotal, "Subtotal", getValue( OrderSubtotal));

	        // Total : OrdersQry, [Subtotal]+[Freight];
	        setValue(Total, "Total", getFloatValue( Subtotal)+getFloatValue( Freight));


            }
        });

        orderdetailsextendedDs.addItemChangeListener(new Datasource.ItemChangeListener<OrderDetailsExtended>() {
            @Override
            public void itemChanged(ItemChangeEvent<OrderDetailsExtended> e) {


            }
        });


    }
}