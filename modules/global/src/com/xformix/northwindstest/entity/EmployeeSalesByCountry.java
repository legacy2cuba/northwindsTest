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

@NamePattern("%s %s|lastname,firstname")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rownum"))
})
@Table(name = "employee_sales_by_country")
@Entity(name = "northwindsTest$EmployeeSalesByCountry")
public class EmployeeSalesByCountry extends BaseLongIdEntity {
    @Column(name = "country", length = 15)
    protected String country;

    @Column(name = "lastname", length = 20)
    protected String lastname;

    @Column(name = "firstname", length = 10)
    protected String firstname;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "shippeddate")
    protected Date shippeddate;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    protected Orders orderid;

    @Column(name = "saleamount")
    protected Double saleamount;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

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

    public void setSaleamount(Double saleamount) {
        this.saleamount = saleamount;
    }

    public Double getSaleamount() {
        return saleamount;
    }


}

