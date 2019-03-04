package com.xformix.northwindstest.reports.alphabetical_list_of_products;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.AlphabeticalListOfProducts ;

public class Alphabetical_list_of_productsCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<AlphabeticalListOfProducts> alphabeticallistofproductsDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.TextField FirstLetterofName;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductName;

    @Inject
    com.haulmont.cuba.gui.components.TextField QuantityPerUnit;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitsInStock;

    @Inject
    com.haulmont.cuba.gui.components.TextField CategoryName;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter1;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageFooter;

    @Inject
    com.haulmont.cuba.gui.components.TextField PageNumber;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportFooter;

    
    @Override
    protected void setReportFieldValue(Object field, String fieldName, String name, Entity ent) {
        if(name.equalsIgnoreCase("DatePrinted")) {
            setValue(field, fieldName, Format( Date(  ),  "dd-mmm-yyyy" ));
        }
        if(name.equalsIgnoreCase("FirstLetterofName")) {
            setValue(field, fieldName, getValue(Left( "ProductName",  1)));
        }
        if(name.equalsIgnoreCase("ProductName")) {
            setValue(field, fieldName, getValue(ent, "productname"));
        }
        if(name.equalsIgnoreCase("QuantityPerUnit")) {
            setValue(field, fieldName, getValue(ent, "quantityperunit"));
        }
        if(name.equalsIgnoreCase("UnitsInStock")) {
            setValue(field, fieldName, getValue(ent, "unitsinstock"));
        }
        if(name.equalsIgnoreCase("CategoryName")) {
            setValue(field, fieldName, getValue(ent, "categoryname"));
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page") +  " of " +  getValue(ent, "pages"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("productname");
       val = (""+val).substring(0, 1);
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("productname");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    addReportSection("reportheader", ReportHeader, -1, alphabeticallistofproductsDs);
    addReportSection("pageheader", PageHeader, -1, alphabeticallistofproductsDs);
    addReportSection("groupheader0", GroupHeader0, 0, alphabeticallistofproductsDs);
    addReportSection("detail", Detail, -1, alphabeticallistofproductsDs);
    addReportSection("groupfooter1", GroupFooter1, 0, alphabeticallistofproductsDs);
    addReportSection("pagefooter", PageFooter, -1, alphabeticallistofproductsDs);
    addReportSection("reportfooter", ReportFooter, -1, alphabeticallistofproductsDs);

	alphabeticallistofproductsDs.addStateChangeListener(new Datasource.StateChangeListener<AlphabeticalListOfProducts>() {
	    @Override
	    public void stateChanged(StateChangeEvent<AlphabeticalListOfProducts> e) {
		fillReport(alphabeticallistofproductsDs);
	    }
	});

    }
}