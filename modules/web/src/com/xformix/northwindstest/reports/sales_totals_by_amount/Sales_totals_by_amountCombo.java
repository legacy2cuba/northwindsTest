package com.xformix.northwindstest.reports.sales_totals_by_amount;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.SalesTotalsByAmount ;

public class Sales_totals_by_amountCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<SalesTotalsByAmount> salestotalsbyamountDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.gui.components.TextField SaleAmount;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrderID;

    @Inject
    com.haulmont.cuba.gui.components.TextField CompanyName;

    @Inject
    com.haulmont.cuba.gui.components.TextField Counter;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter0;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageFooter;

    @Inject
    com.haulmont.cuba.gui.components.TextField PageNumber;

    @Inject
    com.haulmont.cuba.gui.components.TextField PageTotal;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportFooter;

    
    @Override
    protected void setReportFieldValue(Object field, String fieldName, String name, Entity ent) {
        if(name.equalsIgnoreCase("DatePrinted")) {
            setValue(field, fieldName, Format( Date(  ),  "dd-mmm-yyyy" ));
        }
        if(name.equalsIgnoreCase("SaleAmount")) {
            setValue(field, fieldName, getValue(ent, "saleamount"));
        }
        if(name.equalsIgnoreCase("OrderID")) {
            setValue(field, fieldName, getValue(ent, "orderid.id"));
        }
        if(name.equalsIgnoreCase("CompanyName")) {
            setValue(field, fieldName, getValue(ent, "companyname"));
        }
        if(name.equalsIgnoreCase("Counter")) {
            setValue(field, fieldName,  getValue(ent, ""));
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page") +  " of " +  getValue(ent, "pages"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("saleamount");
       val = (int)(Float.parseFloat(val+"")/1000);
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("saleamount");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("SaleAmount", "$#,##0.00;($#,##0.00)");
    formats.put("PageTotal", "$#,##0.00;($#,##0.00)");
    addReportSection("reportheader", ReportHeader, -1, salestotalsbyamountDs);
    addReportSection("pageheader", PageHeader, -1, salestotalsbyamountDs);
    addReportSection("detail", Detail, -1, salestotalsbyamountDs);
    addReportSection("groupfooter0", GroupFooter0, 0, salestotalsbyamountDs);
    addReportSection("pagefooter", PageFooter, -1, salestotalsbyamountDs);
    addReportSection("reportfooter", ReportFooter, -1, salestotalsbyamountDs);

	salestotalsbyamountDs.addStateChangeListener(new Datasource.StateChangeListener<SalesTotalsByAmount>() {
	    @Override
	    public void stateChanged(StateChangeEvent<SalesTotalsByAmount> e) {
		fillReport(salestotalsbyamountDs);
	    }
	});

    }
}