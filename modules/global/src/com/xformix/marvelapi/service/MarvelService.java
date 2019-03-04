package com.xformix.marvelapi.service;

import java.util.List;

import com.xformix.marvelapi.entity.MarvelCharacter;
import com.xformix.marvelapi.entity.MarvelComic;
import com.xformix.marvelapi.entity.MarvelSeries;

public interface MarvelService {
	String NAME = "marvelapi_MarvelService";

	List<MarvelCharacter> getCharacters(String startsWith);

	List<MarvelSeries> getSeries(String startsWith);

	List<MarvelComic> getComics(String startsWith);

	List<MarvelComic> getComicsBySeriesId(Integer seriesId);

	MarvelComic getComicById(Integer comicId);
}