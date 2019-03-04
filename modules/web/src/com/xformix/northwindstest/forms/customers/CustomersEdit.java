package com.xformix.northwindstest.forms.customers;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.Datasource.ItemChangeEvent;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.vaadin.ui.Layout;
import com.xformix.cuba.maps.tomtom.TomtomMap;
import com.xformix.northwindstest.entity.Customers;

public class CustomersEdit extends AbstractEditor<Customers> {
    
	@Inject
	VBoxLayout mapBox;
	
	@Inject
	GroupDatasource<Customers, String> customersDs;
	
	Layout mapLayout;
	TomtomMap mapobject;
	String tomtomKey = "5GQA8S87McddYw89sUDXamTO6cm6BiNc";
	
    @Override
    public void init(Map<String, Object> params) {
    	super.init(params);
    	
    	/**
    	 * YOU MUST GET YOUR OWN KEY (VALID FOR USE OF MAPS AND SEARCH APIS)  FROM THE TOMTOM SITE:
    	 * https://developer.tomtom.com/
    	 */
    	
    	mapobject = new TomtomMap();
    	mapobject.setup(mapBox, tomtomKey, 4, 55.95f, -3.19f);	
    	
    	customersDs.addItemChangeListener(new Datasource.ItemChangeListener<Customers>() {
			@Override
			public void itemChanged(ItemChangeEvent<Customers> e) {
				Customers cust = e.getItem();
				mapobject.showMap(cust.getAddress()+", "+cust.getCity()+", "+cust.getCountry(), 16);
			}
		});
    }

}