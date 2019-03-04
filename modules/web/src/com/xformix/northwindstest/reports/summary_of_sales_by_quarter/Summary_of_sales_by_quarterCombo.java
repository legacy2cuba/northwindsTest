package com.xformix.northwindstest.reports.summary_of_sales_by_quarter;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.SummaryOfSalesByQuarter ;

public class Summary_of_sales_by_quarterCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<SummaryOfSalesByQuarter> summaryofsalesbyquarterDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.TextField Quarter;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter2;

    @Inject
    com.haulmont.cuba.gui.components.TextField Year;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrdersShipped;

    @Inject
    com.haulmont.cuba.gui.components.TextField QuarterSales;

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
        if(name.equalsIgnoreCase("Quarter")) {
            setValue(field, fieldName, DatePart(  "q",  getValue(ent, "shippeddate") ));
        }
        if(name.equalsIgnoreCase("Year")) {
            setValue(field, fieldName, DatePart(  "yyyy",  getValue(ent, "shippeddate") ));
        }
        if(name.equalsIgnoreCase("OrdersShipped")) {
            setValue(field, fieldName, Count("1"));
        }
        if(name.equalsIgnoreCase("QuarterSales")) {
            setValue(field, fieldName, Sum("QuarterSales"));
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       String val = ""+DatePart(  "q",  getValue(entity, "shippeddate") );
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("shippeddate");
        val = ((java.util.Date)val).getYear();
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("QuarterSales", "$#,##0.00;($#,##0.00)");
    addCollector("QuarterSales", "Subtotal");
    addReportSection("reportheader", ReportHeader, -1, summaryofsalesbyquarterDs);
    addReportSection("pageheader", PageHeader, -1, summaryofsalesbyquarterDs);
    addReportSection("groupheader0", GroupHeader0, 0, summaryofsalesbyquarterDs);
    addReportSection("detail", Detail, -1, summaryofsalesbyquarterDs);
    addReportSection("groupfooter2", GroupFooter2, 1, summaryofsalesbyquarterDs);
    addReportSection("groupfooter1", GroupFooter1, 0, summaryofsalesbyquarterDs);
    addReportSection("pagefooter", PageFooter, -1, summaryofsalesbyquarterDs);
    addReportSection("reportfooter", ReportFooter, -1, summaryofsalesbyquarterDs);

	summaryofsalesbyquarterDs.addStateChangeListener(new Datasource.StateChangeListener<SummaryOfSalesByQuarter>() {
	    @Override
	    public void stateChanged(StateChangeEvent<SummaryOfSalesByQuarter> e) {
		fillReport(summaryofsalesbyquarterDs);
	    }
	});

    }
}