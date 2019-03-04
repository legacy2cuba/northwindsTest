package com.xformix.northwindstest.forms.quarterly_orders;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.haulmont.cuba.gui.data.impl.ValueGroupDatasourceImpl;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.QuarterlyOrders ;
import com.xformix.northwindstest.entity.QuarterlyOrdersByProduct ;

public class Quarterly_ordersCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<QuarterlyOrders> quarterlyordersDs ;

    @Inject
    Datasource<QuarterlyOrdersByProduct> quarterlyordersbyproductDs ;

    @Inject
    ValueGroupDatasourceImpl sumqtr_4Ds;

    @Inject
    ValueGroupDatasourceImpl sumqtr_1Ds;

    @Inject
    ValueGroupDatasourceImpl sumqtr_3Ds;

    @Inject
    ValueGroupDatasourceImpl sumqtr_2Ds;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductName;

    @Inject
    com.haulmont.cuba.gui.components.TextField Qtr_1;

    @Inject
    com.haulmont.cuba.gui.components.TextField Qtr_2;

    @Inject
    com.haulmont.cuba.gui.components.TextField Qtr_3;

    @Inject
    com.haulmont.cuba.gui.components.TextField Qtr_4;

    @Inject
    com.haulmont.cuba.gui.components.TextField TotalQ1;

    @Inject
    com.haulmont.cuba.gui.components.TextField TotalQ2;

    @Inject
    com.haulmont.cuba.gui.components.TextField TotalQ3;

    @Inject
    com.haulmont.cuba.gui.components.TextField TotalQ4;

    @Inject
    com.haulmont.cuba.gui.components.TextField Total;

    @Inject
    com.haulmont.cuba.gui.components.TextField Year;

    @Inject
    com.haulmont.cuba.gui.components.TextField CustomerID;

    @Inject
    com.haulmont.cuba.gui.components.TextField CompanyName;

    @Inject
    com.haulmont.cuba.gui.components.TextField City;

    @Inject
    com.haulmont.cuba.gui.components.TextField Country;

    @Inject
    com.haulmont.cuba.gui.components.Frame Quarterly_Orders_Subform;

    @Inject
    com.haulmont.cuba.gui.components.TextField GrandTotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField GrandTotalLabel;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, quarterlyordersDs);
        quarterlyordersDs.addItemChangeListener(new Datasource.ItemChangeListener<QuarterlyOrders>() {
            @Override
            public void itemChanged(ItemChangeEvent<QuarterlyOrders> e) {

                // A form element in a header or footer of a sub-form needs to explicitly grab the FIRST element from a CollectionDatasource
            	System.out.println(">>>>> YEAR="+getValue(quarterlyordersbyproductDs, "orderyear"));
                setValue(Year,"Year" , getValue(quarterlyordersbyproductDs, "orderyear"));
                System.out.println("GET YEAR "+getValue(Year)+", "+Year.getValue());
                Object val = getValue(quarterlyordersbyproductDs, "orderyear");
                Year.setValue(val);
                System.out.println("GET YEAR "+getValue(Year)+", "+Year.getValue()+", "+val.getClass());
                
	        // TotalQ1 : QuarterlyOrdersByProduct, NZ(Sum([Qtr 1]));
	        setValue(TotalQ1, "TotalQ1", NZ(getValue(sumqtr_1Ds, "sumqtr_1"), 0));

	        // TotalQ2 : QuarterlyOrdersByProduct, NZ(Sum([Qtr 2]));
	        setValue(TotalQ2, "TotalQ2", NZ(getValue(sumqtr_2Ds, "sumqtr_2"), 0));

	        // TotalQ3 : QuarterlyOrdersByProduct, NZ(Sum([Qtr 3]));
	        setValue(TotalQ3, "TotalQ3", NZ(getValue(sumqtr_3Ds, "sumqtr_3"), 0));

	        // TotalQ4 : QuarterlyOrdersByProduct, NZ(Sum([Qtr 4]));
	        setValue(TotalQ4, "TotalQ4", NZ(getValue(sumqtr_4Ds, "sumqtr_4"), 0));

	        // Total : QuarterlyOrdersByProduct, [TotalQ1]+[TotalQ2]+[TotalQ3]+[TotalQ4];
	        setValue(Total, "Total", getFloatValue( TotalQ1)+getFloatValue( TotalQ2)+getFloatValue( TotalQ3)+getFloatValue( TotalQ4));

	        // GrandTotal : QuarterlyOrders, [Quarterly Orders Subform]!Total;
	        setValue(GrandTotal, "GrandTotal", getValue( Total));

	        // GrandTotalLabel : QuarterlyOrders, \"Grand Total for \" & [Forms]![Quarterly Orders]![Quarterly Orders Subform].[Form]![Year];
	        setValue(GrandTotalLabel, "GrandTotalLabel",  "Grand Total for " + getValue( Year));


            }
        });

        quarterlyordersbyproductDs.addItemChangeListener(new Datasource.ItemChangeListener<QuarterlyOrdersByProduct>() {
            @Override
            public void itemChanged(ItemChangeEvent<QuarterlyOrdersByProduct> e) {


            }
        });


    }
}