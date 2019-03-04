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
@Table(name = "summary_of_sales_by_quarter")
@Entity(name = "northwindsTest$SummaryOfSalesByQuarter")
public class SummaryOfSalesByQuarter extends BaseLongIdEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "shippeddate")
    protected Date shippeddate;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    protected Orders orderid;

    @Column(name = "subtotal")
    protected Double subtotal;

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    public Date getShippeddate() {
        return shippeddate;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }

    public Orders getOrderid() {
        return orderid;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getSubtotal() {
        return subtotal;
    }


}

