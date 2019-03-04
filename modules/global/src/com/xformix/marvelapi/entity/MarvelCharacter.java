package com.xformix.marvelapi.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.xformix.apitools.JSONPath;

@NamePattern("%s|name")
@MetaClass(name = "marvelapi$MarvelCharacter")
public class MarvelCharacter extends BaseUuidEntity {
    private static final long serialVersionUID = -7215572237061749932L;

    @MetaProperty
    protected String name;

    @JSONPath(path="id")
    @MetaProperty
    protected Integer marvelid;

    @JSONPath(path="thumbnail/path|{/standard_xlarge.}|thumbnail/extension")
    @MetaProperty
	private String thumbnail;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarvelid(Integer marvelid) {
        this.marvelid = marvelid;
    }

    public Integer getMarvelid() {
        return marvelid;
    }

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


}