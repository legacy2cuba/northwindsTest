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

@NamePattern("%s|companyname")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rownum"))
})
@Table(name = "sales_totals_by_amount")
@Entity(name = "northwindsTest$SalesTotalsByAmount")
public class SalesTotalsByAmount extends BaseLongIdEntity {
    @Column(name = "saleamount")
    protected Double saleamount;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    protected Orders orderid;

    @Column(name = "companyname", length = 40)
    protected String companyname;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "shippeddate")
    protected Date shippeddate;

    public void setSaleamount(Double saleamount) {
        this.saleamount = saleamount;
    }

    public Double getSaleamount() {
        return saleamount;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }

    public Orders getOrderid() {
        return orderid;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    public Date getShippeddate() {
        return shippeddate;
    }


}

