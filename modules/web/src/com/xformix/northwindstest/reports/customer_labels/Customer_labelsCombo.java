package com.xformix.northwindstest.reports.customer_labels;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.Customers ;

public class Customer_labelsCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<Customers> customersDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.gui.components.TextField CompanyNameLine;

    @Inject
    com.haulmont.cuba.gui.components.TextField Address1Line;

    @Inject
    com.haulmont.cuba.gui.components.TextField Address2Line;

    @Inject
    com.haulmont.cuba.gui.components.TextField CountryLine;

    
    @Override
    protected void setReportFieldValue(Object field, String fieldName, String name, Entity ent) {
        if(name.equalsIgnoreCase("CompanyNameLine")) {
            setValue(field, fieldName, ( getValue(ent, "companyname")).toString().trim());
        }
        if(name.equalsIgnoreCase("Address1Line")) {
            setValue(field, fieldName, ( getValue(ent, "address")).toString().trim());
        }
        if(name.equalsIgnoreCase("Address2Line")) {
            setValue(field, fieldName, ( getValue(ent, "city") +  " " +  getValue(ent, "region") +  "  " +  getValue(ent, "postalcode")).toString().trim());
        }
        if(name.equalsIgnoreCase("CountryLine")) {
            setValue(field, fieldName, ( getValue(ent, "country")).toString().trim());
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("country");
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("postalcode");
       return val+"";
   }

    public String getBreakValue2(Entity entity) {
       Object val = entity.getValue("companyname");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    addReportSection("detail", Detail, -1, customersDs);

	customersDs.addStateChangeListener(new Datasource.StateChangeListener<Customers>() {
	    @Override
	    public void stateChanged(StateChangeEvent<Customers> e) {
		fillReport(customersDs);
	    }
	});

    }
}