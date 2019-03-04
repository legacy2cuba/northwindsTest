package com.xformix.northwindstest.reports.employee_sales_by_country;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.EmployeeSalesByCountry ;

public class Employee_sales_by_countryCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<EmployeeSalesByCountry> employeesalesbycountryDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField Range;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader0;

    @Inject
    com.haulmont.cuba.gui.components.TextField Country;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader2;

    @Inject
    com.haulmont.cuba.gui.components.TextField Salesperson;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrderID;

    @Inject
    com.haulmont.cuba.gui.components.TextField SaleAmount;

    @Inject
    com.haulmont.cuba.gui.components.TextField PercentOfSalespersonTotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField PercentOfCountryTotal;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter3;

    @Inject
    com.haulmont.cuba.gui.components.TextField SalespersonTotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField EmployeeTotalCaption;

    @Inject
    com.haulmont.cuba.gui.components.TextField PercentOfCountryTotal2;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter1;

    @Inject
    com.haulmont.cuba.gui.components.TextField CountryTotalCaption;

    @Inject
    com.haulmont.cuba.gui.components.TextField CountryTotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField PercentOfGrandTotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField PercentOfGrandTotalLabel;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageFooter;

    @Inject
    com.haulmont.cuba.gui.components.TextField PageNumber;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout ReportFooter;

    @Inject
    com.haulmont.cuba.gui.components.TextField GrandTotal;

    
    @Override
    protected void setReportFieldValue(Object field, String fieldName, String name, Entity ent) {
        if(name.equalsIgnoreCase("Range")) {
            setValue(field, fieldName,  "Sales from " +  getValue(ent, "beginning_date") +  " to " +  getValue(ent, "ending_date"));
        }
        if(name.equalsIgnoreCase("Country")) {
            setValue(field, fieldName, getValue(ent, "country"));
        }
        if(name.equalsIgnoreCase("Salesperson")) {
            setValue(field, fieldName,  getValue(ent, "lastname") +  ", " +  getValue(ent, "firstname"));
        }
        if(name.equalsIgnoreCase("OrderID")) {
            setValue(field, fieldName, getValue(ent, "orderid.id"));
        }
        if(name.equalsIgnoreCase("SaleAmount")) {
            setValue(field, fieldName, getValue(ent, "saleamount"));
        }
        if(name.equalsIgnoreCase("PercentOfSalespersonTotal")) {
	        addFutureSetter("SalespersonTotal", ent, new FutureRunnable() {
                  public void run(FutureSetter f) {
                    setValue(field, fieldName, getFloatValue( f.getValue("SaleAmount"))/getFloatValue( f.getValue("SalespersonTotal")));
                  }
               });
        }
        if(name.equalsIgnoreCase("PercentOfCountryTotal")) {
	        addFutureSetter("CountryTotal", ent, new FutureRunnable() {
                  public void run(FutureSetter f) {
                    setValue(field, fieldName, getFloatValue( f.getValue("SaleAmount"))/getFloatValue( f.getValue("CountryTotal")));
                  }
               });
        }
        if(name.equalsIgnoreCase("SalespersonTotal")) {
            setValue(field, fieldName, Sum("SalespersonTotal"));
        }
        if(name.equalsIgnoreCase("EmployeeTotalCaption")) {
            setValue(field, fieldName,  "Total for " + getValue( "Salesperson") +  ":");
        }
        if(name.equalsIgnoreCase("PercentOfCountryTotal2")) {
	        addFutureSetter("CountryTotal", ent, new FutureRunnable() {
                  public void run(FutureSetter f) {
                    setValue(field, fieldName, getFloatValue( f.getValue("SalespersonTotal"))/getFloatValue( f.getValue("CountryTotal")));
                  }
               });
        }
        if(name.equalsIgnoreCase("CountryTotalCaption")) {
            setValue(field, fieldName,  "Total for " + getValue( "Country") +  ":");
        }
        if(name.equalsIgnoreCase("CountryTotal")) {
            setValue(field, fieldName, Sum("CountryTotal"));
        }
        if(name.equalsIgnoreCase("PercentOfGrandTotal")) {
	        addFutureSetter("GrandTotal", ent, new FutureRunnable() {
                  public void run(FutureSetter f) {
                    setValue(field, fieldName, getFloatValue( f.getValue("CountryTotal"))/getFloatValue( f.getValue("GrandTotal")));
                  }
               });
        }
        if(name.equalsIgnoreCase("PercentOfGrandTotalLabel")) {
            setValue(field, fieldName,  "Percent " + getValue( "Country") +  " is of Grand Total:");
        }
        if(name.equalsIgnoreCase("PageNumber")) {
            setValue(field, fieldName, getValue( "Country") +  " -  Page " +  getValue(ent, "page"));
        }
        if(name.equalsIgnoreCase("DatePrinted")) {
            setValue(field, fieldName, Format( Date(  ),  "Medium Date" ));
        }
        if(name.equalsIgnoreCase("GrandTotal")) {
            setValue(field, fieldName, Sum("GrandTotal"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("country");
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       String val = ""+ getValue(entity, "lastname") +  ", " +  getValue(entity, "firstname");
       return val+"";
   }

    public String getBreakValue2(Entity entity) {
       Object val = entity.getValue("orderid");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("SaleAmount", "$#,##0.00;($#,##0.00)");
    formats.put("PercentOfSalespersonTotal", "Percent");
    formats.put("PercentOfCountryTotal", "Percent");
    formats.put("SalespersonTotal", "$#,##0.00;($#,##0.00)");
    formats.put("PercentOfCountryTotal2", "Percent");
    formats.put("CountryTotal", "$#,##0.00;($#,##0.00)");
    formats.put("PercentOfGrandTotal", "Percent");
    formats.put("GrandTotal", "$#,##0.00;($#,##0.00)");
    addCollector("SalespersonTotal", "SaleAmount");
    addCollector("CountryTotal", "SaleAmount");
    addCollector("GrandTotal", "SaleAmount");
    addReportSection("reportheader", ReportHeader, -1, employeesalesbycountryDs);
    addReportSection("pageheader", PageHeader, -1, employeesalesbycountryDs);
    addReportSection("groupheader0", GroupHeader0, 0, employeesalesbycountryDs);
    addReportSection("groupheader2", GroupHeader2, 1, employeesalesbycountryDs);
    addReportSection("detail", Detail, -1, employeesalesbycountryDs);
    addReportSection("groupfooter3", GroupFooter3, 1, employeesalesbycountryDs);
    addReportSection("groupfooter1", GroupFooter1, 0, employeesalesbycountryDs);
    addReportSection("pagefooter", PageFooter, -1, employeesalesbycountryDs);
    addReportSection("reportfooter", ReportFooter, -1, employeesalesbycountryDs);

	employeesalesbycountryDs.addStateChangeListener(new Datasource.StateChangeListener<EmployeeSalesByCountry>() {
	    @Override
	    public void stateChanged(StateChangeEvent<EmployeeSalesByCountry> e) {
		fillReport(employeesalesbycountryDs);
	    }
	});

    }
}