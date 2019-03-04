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

@NamePattern("%s|productname")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "productid"))
})
@Table(name = "products")
@Entity(name = "northwindsTest$Products")
public class Products extends BaseIntegerIdEntity {
    @Column(name = "productname", length = 40)
    protected String productname;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplierid")
    protected Suppliers supplierid;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid")
    protected Categories categoryid;

    @Column(name = "quantityperunit", length = 20)
    protected String quantityperunit;

    @Column(name = "unitprice")
    protected Double unitprice;

    @Column(name = "unitsinstock")
    protected Integer unitsinstock;

    @Column(name = "unitsonorder")
    protected Integer unitsonorder;

    @Column(name = "reorderlevel")
    protected Integer reorderlevel;

    @Column(name = "discontinued")
    protected Boolean discontinued;

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public void setSupplierid(Suppliers supplierid) {
        this.supplierid = supplierid;
    }

    public Suppliers getSupplierid() {
        return supplierid;
    }

    public void setCategoryid(Categories categoryid) {
        this.categoryid = categoryid;
    }

    public Categories getCategoryid() {
        return categoryid;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsonorder(Integer unitsonorder) {
        this.unitsonorder = unitsonorder;
    }

    public Integer getUnitsonorder() {
        return unitsonorder;
    }

    public void setReorderlevel(Integer reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    public Integer getReorderlevel() {
        return reorderlevel;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }


}

