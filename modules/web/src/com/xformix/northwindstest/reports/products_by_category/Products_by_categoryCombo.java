package com.xformix.northwindstest.reports.products_by_category;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.ProductsByCategory ;

public class Products_by_categoryCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<ProductsByCategory> productsbycategoryDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.TextField CategoryName;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductName;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitsInStock;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter1;

    @Inject
    com.haulmont.cuba.gui.components.TextField NumberOfProducts;

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
        if(name.equalsIgnoreCase("CategoryName")) {
            setValue(field, fieldName, getValue(ent, "categoryname"));
        }
        if(name.equalsIgnoreCase("ProductName")) {
            setValue(field, fieldName, getValue(ent, "productname"));
        }
        if(name.equalsIgnoreCase("UnitsInStock")) {
            setValue(field, fieldName, getValue(ent, "unitsinstock"));
        }
        if(name.equalsIgnoreCase("NumberOfProducts")) {
            setValue(field, fieldName, Count("0"));
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("categoryname");
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("productname");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("UnitsInStock", "General Number");
    addReportSection("reportheader", ReportHeader, -1, productsbycategoryDs);
    addReportSection("pageheader", PageHeader, -1, productsbycategoryDs);
    addReportSection("groupheader0", GroupHeader0, 0, productsbycategoryDs);
    addReportSection("detail", Detail, -1, productsbycategoryDs);
    addReportSection("groupfooter1", GroupFooter1, 0, productsbycategoryDs);
    addReportSection("pagefooter", PageFooter, -1, productsbycategoryDs);
    addReportSection("reportfooter", ReportFooter, -1, productsbycategoryDs);

	productsbycategoryDs.addStateChangeListener(new Datasource.StateChangeListener<ProductsByCategory>() {
	    @Override
	    public void stateChanged(StateChangeEvent<ProductsByCategory> e) {
		fillReport(productsbycategoryDs);
	    }
	});

    }
}