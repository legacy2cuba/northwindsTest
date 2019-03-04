package com.xformix.northwindstest.reports.sales_by_year;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.SalesByYear ;

public class Sales_by_yearCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<SalesByYear> salesbyyearDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField Show;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.Frame Sales_by_Year_Subreport;

    @Inject
    com.haulmont.cuba.gui.components.TextField DetailsLabel;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.gui.components.DateField ShippedDate;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrderID;

    @Inject
    com.haulmont.cuba.gui.components.TextField Subtotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField LineNumber;

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
        if(name.equalsIgnoreCase("YearLabel")) {
            setValue(field, fieldName,  getValue(ent, "year") +  " Summary");
        }
        if(name.equalsIgnoreCase("Quarter")) {
	        addFutureSetter("ShippedDate", ent, new FutureRunnable() {
                  public void run(FutureSetter f) {
                    setValue(field, fieldName, Format(  f.getValue("ShippedDate"),  "q" ));
                  }
               });
        }
        if(name.equalsIgnoreCase("CountSubtotal")) {
            setValue(field, fieldName, Count("1"));
        }
        if(name.equalsIgnoreCase("QtrSubtotal")) {
            setValue(field, fieldName, Sum("QtrSubtotal"));
        }
        if(name.equalsIgnoreCase("CountTotal")) {
            setValue(field, fieldName, Count("0"));
        }
        if(name.equalsIgnoreCase("QuarterTotal")) {
            setValue(field, fieldName, Sum("QuarterTotal"));
        }
        if(name.equalsIgnoreCase("DatePrinted")) {
            setValue(field, fieldName, Format( Date(  ),  "dd-mmm-yyyy" ));
        }
        if(name.equalsIgnoreCase("DetailsLabel")) {
            setValue(field, fieldName,  getValue(ent, "year") +  " Details");
        }
        if(name.equalsIgnoreCase("ShippedDate")) {
            setValue(field, fieldName, getValue(ent, "shippeddate"));
        }
        if(name.equalsIgnoreCase("OrderID")) {
            setValue(field, fieldName, getValue(ent, "orderid.id"));
        }
        if(name.equalsIgnoreCase("Subtotal")) {
            setValue(field, fieldName, getValue(ent, "subtotal"));
        }
        if(name.equalsIgnoreCase("LineNumber")) {
            setValue(field, fieldName,  getValue(ent, ""));
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page") +  " of " +  getValue(ent, "pages"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("shippeddate");
        val = ((java.util.Date)val).getYear();
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("shippeddate");
       return val+"";
   }

    public String getBreakValue2(Entity entity) {
       Object val = entity.getValue("orderid");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("QtrSubtotal", "$#,##0.00;($#,##0.00)");
    formats.put("QuarterTotal", "$#,##0.00;($#,##0.00)");
    formats.put("ShippedDate", "dd-mmm-yyyy");
    formats.put("Subtotal", "$#,##0.00;($#,##0.00)");
    addReportSection("reportheader", ReportHeader, -1, salesbyyearDs);
    addReportSection("pageheader", PageHeader, -1, salesbyyearDs);
    addReportSection("groupheader0", GroupHeader0, 0, salesbyyearDs);
    addReportSection("detail", Detail, -1, salesbyyearDs);
    addReportSection("groupfooter1", GroupFooter1, 0, salesbyyearDs);
    addReportSection("pagefooter", PageFooter, -1, salesbyyearDs);
    addReportSection("reportfooter", ReportFooter, -1, salesbyyearDs);

	salesbyyearDs.addStateChangeListener(new Datasource.StateChangeListener<SalesByYear>() {
	    @Override
	    public void stateChanged(StateChangeEvent<SalesByYear> e) {
		fillReport(salesbyyearDs);
	    }
	});

    }
}