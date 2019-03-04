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
        @AttributeOverride(name = "id", column = @Column(name = "rownum"))
})
@Table(name = "quarterly_orders_by_product")
@Entity(name = "northwindsTest$QuarterlyOrdersByProduct")
public class QuarterlyOrdersByProduct extends BaseLongIdEntity {
    @Column(name = "productname", length = 40)
    protected String productname;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    protected Customers customerid;

    @Column(name = "orderyear", length = 40)
    protected String orderyear;

    @Column(name = "qtr_1")
    protected Double qtr_1;

    @Column(name = "qtr_2")
    protected Double qtr_2;

    @Column(name = "qtr_3")
    protected Double qtr_3;

    @Column(name = "qtr_4")
    protected Double qtr_4;

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public void setCustomerid(Customers customerid) {
        this.customerid = customerid;
    }

    public Customers getCustomerid() {
        return customerid;
    }

    public void setOrderyear(String orderyear) {
        this.orderyear = orderyear;
    }

    public String getOrderyear() {
        return orderyear;
    }

    public void setQtr_1(Double qtr_1) {
        this.qtr_1 = qtr_1;
    }

    public Double getQtr_1() {
        return qtr_1;
    }

    public void setQtr_2(Double qtr_2) {
        this.qtr_2 = qtr_2;
    }

    public Double getQtr_2() {
        return qtr_2;
    }

    public void setQtr_3(Double qtr_3) {
        this.qtr_3 = qtr_3;
    }

    public Double getQtr_3() {
        return qtr_3;
    }

    public void setQtr_4(Double qtr_4) {
        this.qtr_4 = qtr_4;
    }

    public Double getQtr_4() {
        return qtr_4;
    }


}

