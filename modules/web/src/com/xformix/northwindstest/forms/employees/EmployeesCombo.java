package com.xformix.northwindstest.forms.employees;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.UrlResource;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.xformix.cuba.utils.CustomLookup;
import com.xformix.marvelapi.entity.MarvelCharacter;
import com.xformix.northwindstest.entity.Employees;

public class EmployeesCombo extends CustomLookup {

	@Inject
	protected Table navigationTable;

	@Inject
	Datasource<Employees> employeesDs;

	@Inject
	CollectionDatasource<MarvelCharacter, UUID> marvelCharacterDs;

	@Inject
	com.haulmont.cuba.gui.components.TextField EmployeeName;

	@Inject
	com.haulmont.cuba.gui.components.TabSheet TabCtl0;

	@Inject
	com.haulmont.cuba.gui.components.TabSheet.Tab CompanyInfo;

	@Inject
	com.haulmont.cuba.gui.components.TextField EmployeeID;

	@Inject
	com.haulmont.cuba.gui.components.TextField FirstName;

	@Inject
	com.haulmont.cuba.gui.components.TextField LastName;

	@Inject
	com.haulmont.cuba.gui.components.TextField Title;

	@Inject
	com.haulmont.cuba.gui.components.LookupField ReportsTo;

	@Inject
	com.haulmont.cuba.gui.components.DateField HireDate;

	@Inject
	com.haulmont.cuba.gui.components.TextField Extension;

	@Inject
	com.haulmont.cuba.gui.components.TabSheet.Tab PersonalInfo;

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
	com.haulmont.cuba.gui.components.LookupField TitleOfCourtesy;

	@Inject
	com.haulmont.cuba.gui.components.DateField BirthDate;

	@Inject
	com.haulmont.cuba.gui.components.TextArea Notes;

	@Inject
	Image marvelImage;

	@Inject
	Label superheroLabel;

	private MarvelCharacter getCharacter(String startsWith) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("startsWith", startsWith);
		marvelCharacterDs.refresh(params);
		Collection<MarvelCharacter> chars = marvelCharacterDs.getItems();
		if (chars.size() > 0)
			return chars.iterator().next();
		if(startsWith.length() > 0)
			return getCharacter(startsWith.substring(0, startsWith.length()-1));
		return null;
	}

	@Override
	public void init(Map<String, Object> params) {

		setup(navigationTable, employeesDs);
		employeesDs.addItemChangeListener(new Datasource.ItemChangeListener<Employees>() {
			@Override
			public void itemChanged(ItemChangeEvent<Employees> e) {

				// EmployeeName : Employees, [FirstName] & \" \" & [LastName];
				setValue(EmployeeName, "EmployeeName", getValue(FirstName) + " " + getValue(LastName));

				try {
					Employees emp = e.getItem();
					MarvelCharacter superHero = getCharacter(emp.getFirstname().substring(0, 3));
					superheroLabel.setValue(superHero.getName());
					marvelImage.setSource(UrlResource.class).setUrl(new URL(superHero.getThumbnail()));
				} catch (Exception e1) {
					System.out.println("INFO: unable to load image, error: " + e1);
				}

			}
		});

	}
}