package com.xformix.northwindstest.reports.sales_by_category;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.SalesByCategory ;

public class Sales_by_categoryCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<SalesByCategory> salesbycategoryDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DateLabel;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.Frame Sales_by_Category_Subreport;

    @Inject
    com.haulmont.cuba.gui.components.TextField CategoryID;

    @Inject
    com.haulmont.cuba.gui.components.TextArea CategoryName;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageFooter;

    @Inject
    com.haulmont.cuba.gui.components.TextField Text9;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportFooter;

    
    @Override
    protected void setReportFieldValue(Object field, String fieldName, String name, Entity ent) {
        if(name.equalsIgnoreCase("ProductName")) {
            setValue(field, fieldName, getValue(ent, "productname"));
        }
        if(name.equalsIgnoreCase("ProductSales")) {
            setValue(field, fieldName, getValue(ent, "productsales"));
        }
        if(name.equalsIgnoreCase("DateLabel")) {
            setValue(field, fieldName, Format( Date(  ),  "Long Date" ));
        }
        if(name.equalsIgnoreCase("CategoryID")) {
            setValue(field, fieldName, getValue(ent, "categoryid.id"));
        }
        if(name.equalsIgnoreCase("CategoryName")) {
            setValue(field, fieldName, getValue(ent, "categoryname"));
        }
        if(name.equalsIgnoreCase("Text9")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page") +  " of " +  getValue(ent, "pages"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("categoryname");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("ProductSales", "$#,##0.00;($#,##0.00)");
    addReportSection("reportheader", ReportHeader, -1, salesbycategoryDs);
    addReportSection("pageheader", PageHeader, -1, salesbycategoryDs);
    addReportSection("groupheader0", GroupHeader0, 0, salesbycategoryDs);
    addReportSection("detail", Detail, -1, salesbycategoryDs);
    addReportSection("pagefooter", PageFooter, -1, salesbycategoryDs);
    addReportSection("reportfooter", ReportFooter, -1, salesbycategoryDs);

	salesbycategoryDs.addStateChangeListener(new Datasource.StateChangeListener<SalesByCategory>() {
	    @Override
	    public void stateChanged(StateChangeEvent<SalesByCategory> e) {
		fillReport(salesbycategoryDs);
	    }
	});

    }
}