package com.xformix.northwindstest.reports.invoice;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.StateChangeEvent;
import com.xformix.cuba.utils.ReportGenerator;
import com.xformix.northwindstest.entity.Invoices ;

public class InvoiceCombo extends ReportGenerator {
    
    @Inject
    protected Table navigationTable;    

    protected int Page;

    protected int Pages;

    @Inject
    Datasource<Invoices> invoicesDs ;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageHeader;

    @Inject
    com.haulmont.cuba.gui.components.TextField DatePrinted;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupHeader2;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipName;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipAddress;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipCountry;

    @Inject
    com.haulmont.cuba.gui.components.TextField CompanyName;

    @Inject
    com.haulmont.cuba.gui.components.TextField Address;

    @Inject
    com.haulmont.cuba.gui.components.TextField Country;

    @Inject
    com.haulmont.cuba.gui.components.TextField CustomerID;

    @Inject
    com.haulmont.cuba.gui.components.TextField OrderID;

    @Inject
    com.haulmont.cuba.gui.components.DateField OrderDate;

    @Inject
    com.haulmont.cuba.gui.components.DateField RequiredDate;

    @Inject
    com.haulmont.cuba.gui.components.DateField ShippedDate;

    @Inject
    com.haulmont.cuba.gui.components.TextField Salesperson;

    @Inject
    com.haulmont.cuba.gui.components.TextField Shippers_CompanyName;

    @Inject
    com.haulmont.cuba.gui.components.TextField CityRegionPostalCode;

    @Inject
    com.haulmont.cuba.gui.components.TextField ShipCityRegionPostalCode;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout Detail;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductName;

    @Inject
    com.haulmont.cuba.gui.components.TextField UnitPrice;

    @Inject
    com.haulmont.cuba.gui.components.TextField Quantity;

    @Inject
    com.haulmont.cuba.gui.components.TextField Discount;

    @Inject
    com.haulmont.cuba.gui.components.TextField ExtendedPrice;

    @Inject
    com.haulmont.cuba.gui.components.TextField ProductID;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout GroupFooter3;

    @Inject
    com.haulmont.cuba.gui.components.TextField InvoiceSubtotal;

    @Inject
    com.haulmont.cuba.gui.components.TextField Freight;

    @Inject
    com.haulmont.cuba.gui.components.TextField InvoiceTotal;

    @Inject
    com.haulmont.cuba.web.gui.components.WebGridLayout PageFooter;

    
    @Override
    protected void setReportFieldValue(Object field, String fieldName, String name, Entity ent) {
        if(name.equalsIgnoreCase("DatePrinted")) {
            setValue(field, fieldName, Format( Date(  ),  "dd-mmm-yyyy" ));
        }
        if(name.equalsIgnoreCase("ShipName")) {
            setValue(field, fieldName, getValue(ent, "shipname"));
        }
        if(name.equalsIgnoreCase("ShipAddress")) {
            setValue(field, fieldName, getValue(ent, "shipaddress"));
        }
        if(name.equalsIgnoreCase("ShipCountry")) {
            setValue(field, fieldName, getValue(ent, "shipcountry"));
        }
        if(name.equalsIgnoreCase("CompanyName")) {
            setValue(field, fieldName, getValue(ent, "companyname"));
        }
        if(name.equalsIgnoreCase("Address")) {
            setValue(field, fieldName, getValue(ent, "address"));
        }
        if(name.equalsIgnoreCase("Country")) {
            setValue(field, fieldName, getValue(ent, "country"));
        }
        if(name.equalsIgnoreCase("CustomerID")) {
            setValue(field, fieldName, getValue(ent, "customerid.id"));
        }
        if(name.equalsIgnoreCase("OrderID")) {
            setValue(field, fieldName, getValue(ent, "orderid.id"));
        }
        if(name.equalsIgnoreCase("OrderDate")) {
            setValue(field, fieldName, getValue(ent, "orderdate"));
        }
        if(name.equalsIgnoreCase("RequiredDate")) {
            setValue(field, fieldName, getValue(ent, "requireddate"));
        }
        if(name.equalsIgnoreCase("ShippedDate")) {
            setValue(field, fieldName, getValue(ent, "shippeddate"));
        }
        if(name.equalsIgnoreCase("Salesperson")) {
            setValue(field, fieldName, getValue(ent, "salesperson"));
        }
        if(name.equalsIgnoreCase("Shippers_CompanyName")) {
            setValue(field, fieldName, getValue(ent, "companyname"));
        }
        if(name.equalsIgnoreCase("CityRegionPostalCode")) {
            setValue(field, fieldName, iif( getValue(ent, "region") == null,  getValue(ent, "city") +  "  " +  getValue(ent, "postalcode"),  getValue(ent, "city") +  " " +  getValue(ent, "region") +  "  " +  getValue(ent, "postalcode")));
        }
        if(name.equalsIgnoreCase("ShipCityRegionPostalCode")) {
            setValue(field, fieldName, iif( getValue(ent, "region") == null,  getValue(ent, "shipcity") +  "  " +  getValue(ent, "shippostalcode"),  getValue(ent, "shipcity") +  " " +  getValue(ent, "shipregion") +  "  " +  getValue(ent, "shippostalcode")));
        }
        if(name.equalsIgnoreCase("ProductName")) {
            setValue(field, fieldName, getValue(ent, "productname"));
        }
        if(name.equalsIgnoreCase("UnitPrice")) {
            setValue(field, fieldName, getValue(ent, "unitprice"));
        }
        if(name.equalsIgnoreCase("Quantity")) {
            setValue(field, fieldName, getValue(ent, "quantity"));
        }
        if(name.equalsIgnoreCase("Discount")) {
            setValue(field, fieldName, getValue(ent, "discount"));
        }
        if(name.equalsIgnoreCase("ExtendedPrice")) {
            setValue(field, fieldName, getValue(ent, "extendedprice"));
        }
        if(name.equalsIgnoreCase("ProductID")) {
            setValue(field, fieldName, getValue(ent, "productid.id"));
        }
        if(name.equalsIgnoreCase("InvoiceSubtotal")) {
            setValue(field, fieldName, Sum("InvoiceSubtotal"));
        }
        if(name.equalsIgnoreCase("Freight")) {
            setValue(field, fieldName, getValue(ent, "freight"));
        }
        if(name.equalsIgnoreCase("InvoiceTotal")) {
            setValue(field, fieldName, getFloatValue( "InvoiceSubtotal")+getFloatValue( "Freight"));
        }

    }
    
    public String getBreakValue0(Entity entity) {
       Object val = entity.getValue("orderid");
       return val+"";
   }

    public String getBreakValue1(Entity entity) {
       Object val = entity.getValue("productid");
       return val+"";
   }



    @Override
    public void init(Map<String, Object> params) {

    formats.put("DatePrinted", "Medium Date");
    formats.put("OrderDate", "dd-mmm-yyyy");
    formats.put("RequiredDate", "dd-mmm-yyyy");
    formats.put("ShippedDate", "dd-mmm-yyyy");
    formats.put("UnitPrice", "$#,##0.00;($#,##0.00)");
    formats.put("Quantity", "General Number");
    formats.put("Discount", "Percent");
    formats.put("ExtendedPrice", "$#,##0.00;($#,##0.00)");
    formats.put("InvoiceSubtotal", "$#,##0.00;($#,##0.00)");
    formats.put("Freight", "$#,##0.00;($#,##0.00)");
    formats.put("InvoiceTotal", "$#,##0.00;($#,##0.00)");
    addCollector("InvoiceSubtotal", "ExtendedPrice");
    addReportSection("pageheader", PageHeader, -1, invoicesDs);
    addReportSection("groupheader2", GroupHeader2, 0, invoicesDs);
    addReportSection("detail", Detail, -1, invoicesDs);
    addReportSection("groupfooter3", GroupFooter3, 0, invoicesDs);
    addReportSection("pagefooter", PageFooter, -1, invoicesDs);

	invoicesDs.addStateChangeListener(new Datasource.StateChangeListener<Invoices>() {
	    @Override
	    public void stateChanged(StateChangeEvent<Invoices> e) {
		fillReport(invoicesDs);
	    }
	});

    }
}