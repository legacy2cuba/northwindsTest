package com.xformix.marvelapi.datasource;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;
import com.xformix.marvelapi.entity.MarvelSeries;
import com.xformix.marvelapi.service.MarvelService;

public class MarvelSeriesDatasource extends CustomCollectionDatasource<MarvelSeries, UUID> {

	private MarvelService marvelService = AppBeans.get(MarvelService.NAME);

	@Override
	protected Collection<MarvelSeries> getEntities(Map params) {
		if (params.get("startsWith") == null) {
			throw new RuntimeException("The parameter startsWith must be specified");
		}
		return marvelService.getSeries((String) params.get("startsWith"));
	}

}
