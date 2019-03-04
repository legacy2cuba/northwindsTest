package com.xformix.northwindstest.reports.copy_of_summary_of_sales_by_year;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.SummaryOfSalesByYear ;

public class Copy_of_summary_of_sales_by_yearCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<SummaryOfSalesByYear> summaryofsalesbyyearDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.TextField Year;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter2;

    @Inject
    com.haulmont.cuba.gui.components.TextField Quarter;

    @Inject
    com.haulmont.cuba.gui.components.TextField QuarterOrderCount;

    @Inject
    com.haulmont.cuba.gui.components.TextField QuarterSales;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter1;

    @Inject
    com.haulmont.cuba.gui.components.TextField YearOrderCount;

    @Inject
    com.haulmont.cuba.gui.components.TextField YearTotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField TotalsForYearLabel;

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
        if(name.equalsIgnoreCase("Year")) {
            setValue(field, fieldName, DatePart(  "yyyy",  getValue(ent, "shippeddate") ));
        }
        if(name.equalsIgnoreCase("Quarter")) {
            setValue(field, fieldName, DatePart(  "q",  getValue(ent, "shippeddate") ));
        }
        if(name.equalsIgnoreCase("QuarterOrderCount")) {
            setValue(field, fieldName, Count("1"));
        }
        if(name.equalsIgnoreCase("QuarterSales")) {
            setValue(field, fieldName, Sum("QuarterSales"));
        }
        if(name.equalsIgnoreCase("YearOrderCount")) {
            setValue(field, fieldName, Count("0"));
        }
        if(name.equalsIgnoreCase("YearTotal")) {
            setValue(field, fieldName, Sum("YearTotal"));
        }
        if(name.equalsIgnoreCase("TotalsForYearLabel")) {
            setValue(field, fieldName,  "Totals for " + getValue( "Year") +  ":");
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName,  "Page " +  getValue(ent, "page"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("shippeddate");
        val = ((java.util.Date)val).getYear();
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("shippeddate");
        val = (int)(((java.util.Date)val).getMonth()/3) + 1;
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("QuarterSales", "$#,##0.00;($#,##0.00)");
    formats.put("YearTotal", "$#,##0.00;($#,##0.00)");
    addCollector("QuarterSales", "Subtotal");
    addCollector("YearTotal", "Subtotal");
    addReportSection("reportheader", ReportHeader, -1, summaryofsalesbyyearDs);
    addReportSection("pageheader", PageHeader, -1, summaryofsalesbyyearDs);
    addReportSection("groupheader0", GroupHeader0, 0, summaryofsalesbyyearDs);
    addReportSection("detail", Detail, -1, summaryofsalesbyyearDs);
    addReportSection("groupfooter2", GroupFooter2, 1, summaryofsalesbyyearDs);
    addReportSection("groupfooter1", GroupFooter1, 0, summaryofsalesbyyearDs);
    addReportSection("pagefooter", PageFooter, -1, summaryofsalesbyyearDs);
    addReportSection("reportfooter", ReportFooter, -1, summaryofsalesbyyearDs);

	summaryofsalesbyyearDs.addStateChangeListener(new Datasource.StateChangeListener<SummaryOfSalesByYear>() {
	    @Override
	    public void stateChanged(StateChangeEvent<SummaryOfSalesByYear> e) {
		fillReport(summaryofsalesbyyearDs);
	    }
	});

    }
}