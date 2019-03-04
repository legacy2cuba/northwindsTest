package com.xformix.northwindstest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import com.haulmont.cuba.core.global.DesignSupport;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.BaseLongIdEntity;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%d|id")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rownum"))
})
@Table(name = "ten_most_expensive_products")
@Entity(name = "northwindsTest$TenMostExpensiveProducts")
public class TenMostExpensiveProducts extends BaseLongIdEntity {
    @Column(name = "tenmostexpensiveproducts", length = 40)
    protected String tenmostexpensiveproducts;

    @Column(name = "unitprice")
    protected Double unitprice;

    public void setTenmostexpensiveproducts(String tenmostexpensiveproducts) {
        this.tenmostexpensiveproducts = tenmostexpensiveproducts;
    }

    public String getTenmostexpensiveproducts() {
        return tenmostexpensiveproducts;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Double getUnitprice() {
        return unitprice;
    }


}

