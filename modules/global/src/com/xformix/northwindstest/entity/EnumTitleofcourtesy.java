package com.xformix.northwindstest.entity;

import javax.annotation.Nullable;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

public enum EnumTitleofcourtesy implements EnumClass<String> {

     Dr_("Dr."),
     Mr_("Mr."),
     Mrs_("Mrs."),
     Ms_("Ms.");


    private String id;

    EnumTitleofcourtesy(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EnumTitleofcourtesy fromId(String id) {
        for (EnumTitleofcourtesy val : EnumTitleofcourtesy.values()) {
            if (val.getId().equals(id)) {
                return val;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
    
}