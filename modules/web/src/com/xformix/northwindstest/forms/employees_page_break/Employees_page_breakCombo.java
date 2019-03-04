package com.xformix.northwindstest.forms.employees_page_break;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.northwindstest.entity.Employees ;

public class Employees_page_breakCombo extends CustomLookup {
    
    @Inject
    protected Table navigationTable;    

    @Inject
    Datasource<Employees> employeesDs ;

    @Inject
    com.haulmont.cuba.gui.components.TextField EmployeeName;

    @Inject
    com.haulmont.cuba.gui.components.TextField EmployeeID;

    @Inject
    com.haulmont.cuba.gui.components.TextField LastName;

    @Inject
    com.haulmont.cuba.gui.components.TextField FirstName;

    @Inject
    com.haulmont.cuba.gui.components.TextField Title;

    @Inject
    com.haulmont.cuba.gui.components.LookupField ReportsTo;

    @Inject
    com.haulmont.cuba.gui.components.DateField BirthDate;

    @Inject
    com.haulmont.cuba.gui.components.DateField HireDate;

    @Inject
    com.haulmont.cuba.gui.components.TextArea Address;

    @Inject
    com.haulmont.cuba.gui.components.TextField City;

    @Inject
    com.haulmont.cuba.gui.components.TextField Region;

    @Inject
    com.haulmont.cuba.gui.components.TextField PostalCode;

    @Inject
    com.haulmont.cuba.gui.components.TextField Country;

    @Inject
    com.haulmont.cuba.gui.components.TextField HomePhone;

    @Inject
    com.haulmont.cuba.gui.components.TextField Extension;

    @Inject
    com.haulmont.cuba.gui.components.TextArea Notes;

    @Inject
    com.haulmont.cuba.gui.components.LookupField TitleOfCourtesy;

    @Inject
    com.haulmont.cuba.gui.components.Button PersonalInfo;

    @Inject
    com.haulmont.cuba.gui.components.Button CompanyInfo;

    @Override
    public void init(Map<String, Object> params) {

setup(navigationTable, employeesDs);
        employeesDs.addItemChangeListener(new Datasource.ItemChangeListener<Employees>() {
            @Override
            public void itemChanged(ItemChangeEvent<Employees> e) {

	        // EmployeeName : Employees, [FirstName] & \" \" & [LastName];
	        setValue(EmployeeName, "EmployeeName", getValue( FirstName) +  " " + getValue( LastName));


            }
        });


    }
}