package com.xformix.northwindstest.reports.catalog;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.Categories ;
import com.xformix.northwindstest.entity.Products ;

public class CatalogCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<Categories> categoriesDs ;

    @Inject
    Datasource<Products> productsDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.TextField CategoryName;

    @Inject
    com.haulmont.cuba.gui.components.TextArea Description;

    @Inject
    com.haulmont.cuba.gui.components.Frame CatalogSubreport;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

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
        if(name.equalsIgnoreCase("ProductID")) {
            setValue(field, fieldName, getValue(ent, "id"));
        }
        if(name.equalsIgnoreCase("QuantityPerUnit")) {
            setValue(field, fieldName, getValue(ent, "quantityperunit"));
        }
        if(name.equalsIgnoreCase("UnitPrice")) {
            setValue(field, fieldName, getValue(ent, "unitprice"));
        }
        if(name.equalsIgnoreCase("ProductName")) {
            setValue(field, fieldName, getValue(ent, "productname"));
        }
        if(name.equalsIgnoreCase("CategoryName")) {
            setValue(field, fieldName, getValue(ent, "categoryname"));
        }
        if(name.equalsIgnoreCase("Description")) {
            setValue(field, fieldName, getValue(ent, "description"));
        }
        if(name.equalsIgnoreCase("Picture")) {
            setValue(field, fieldName, getValue(ent, "picture"));
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("categoryname");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    addReportSection("reportheader", ReportHeader, -1, categoriesDs);
    addReportSection("pageheader", PageHeader, -1, categoriesDs);
    addReportSection("groupheader0", GroupHeader0, 0, categoriesDs);
    addReportSection("detail", Detail, -1, categoriesDs);
    addReportSection("groupfooter1", GroupFooter1, 0, categoriesDs);
    addReportSection("pagefooter", PageFooter, -1, categoriesDs);
    addReportSection("reportfooter", ReportFooter, -1, categoriesDs);

	categoriesDs.addStateChangeListener(new Datasource.StateChangeListener<Categories>() {
	    @Override
	    public void stateChanged(StateChangeEvent<Categories> e) {
		fillReport(categoriesDs);
	    }
	});

    }
}