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

@NamePattern("%s|categoryname")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rownum"))
})
@Table(name = "product_sales_for_1997")
@Entity(name = "northwindsTest$ProductSalesFor1997")
public class ProductSalesFor1997 extends BaseLongIdEntity {
    @Column(name = "categoryname", length = 15)
    protected String categoryname;

    @Column(name = "productname", length = 40)
    protected String productname;

    @Column(name = "productsales")
    protected Double productsales;

    @Lob
    @Column(name = "shippedquarter")
    protected String shippedquarter;

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductsales(Double productsales) {
        this.productsales = productsales;
    }

    public Double getProductsales() {
        return productsales;
    }

    public void setShippedquarter(String shippedquarter) {
        this.shippedquarter = shippedquarter;
    }

    public String getShippedquarter() {
        return shippedquarter;
    }


}

