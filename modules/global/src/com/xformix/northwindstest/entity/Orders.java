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

@NamePattern("%s|shipname")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "orderid"))
})
@Table(name = "orders")
@Entity(name = "northwindsTest$Orders")
public class Orders extends BaseIntegerIdEntity {
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    protected Customers customerid;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeid")
    protected Employees employeeid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orderdate")
    protected Date orderdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requireddate")
    protected Date requireddate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "shippeddate")
    protected Date shippeddate;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipvia")
    protected Shippers shipvia;

    @Column(name = "freight")
    protected Double freight;

    @Column(name = "shipname", length = 40)
    protected String shipname;

    @Column(name = "shipaddress", length = 60)
    protected String shipaddress;

    @Column(name = "shipcity", length = 15)
    protected String shipcity;

    @Column(name = "shipregion", length = 15)
    protected String shipregion;

    @Column(name = "shippostalcode", length = 10)
    protected String shippostalcode;

    @Column(name = "shipcountry", length = 15)
    protected String shipcountry;

    public void setCustomerid(Customers customerid) {
        this.customerid = customerid;
    }

    public Customers getCustomerid() {
        return customerid;
    }

    public void setEmployeeid(Employees employeeid) {
        this.employeeid = employeeid;
    }

    public Employees getEmployeeid() {
        return employeeid;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }

    public Date getRequireddate() {
        return requireddate;
    }

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    public Date getShippeddate() {
        return shippeddate;
    }

    public void setShipvia(Shippers shipvia) {
        this.shipvia = shipvia;
    }

    public Shippers getShipvia() {
        return shipvia;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getFreight() {
        return freight;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipaddress(String shipaddress) {
        this.shipaddress = shipaddress;
    }

    public String getShipaddress() {
        return shipaddress;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity;
    }

    public String getShipcity() {
        return shipcity;
    }

    public void setShipregion(String shipregion) {
        this.shipregion = shipregion;
    }

    public String getShipregion() {
        return shipregion;
    }

    public void setShippostalcode(String shippostalcode) {
        this.shippostalcode = shippostalcode;
    }

    public String getShippostalcode() {
        return shippostalcode;
    }

    public void setShipcountry(String shipcountry) {
        this.shipcountry = shipcountry;
    }

    public String getShipcountry() {
        return shipcountry;
    }


}

