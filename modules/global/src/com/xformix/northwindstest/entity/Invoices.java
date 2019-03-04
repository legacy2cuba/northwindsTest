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
        @AttributeOverride(name = "id", column = @Column(name = "rownum"))
})
@Table(name = "invoices")
@Entity(name = "northwindsTest$Invoices")
public class Invoices extends BaseLongIdEntity {
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

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    protected Customers customerid;

    @Column(name = "companyname", length = 40)
    protected String companyname;

    @Column(name = "address", length = 60)
    protected String address;

    @Column(name = "city", length = 15)
    protected String city;

    @Column(name = "region", length = 15)
    protected String region;

    @Column(name = "postalcode", length = 10)
    protected String postalcode;

    @Column(name = "country", length = 15)
    protected String country;

    @Lob
    @Column(name = "salesperson")
    protected String salesperson;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    protected Orders orderid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orderdate")
    protected Date orderdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requireddate")
    protected Date requireddate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "shippeddate")
    protected Date shippeddate;

    @Column(name = "shippers_companyname", length = 40)
    protected String shippers_companyname;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid")
    protected Products productid;

    @Column(name = "productname", length = 40)
    protected String productname;

    @Column(name = "unitprice")
    protected Double unitprice;

    @Column(name = "quantity")
    protected Integer quantity;

    @Column(name = "discount")
    protected Double discount;

    @Column(name = "extendedprice", length = 40)
    protected String extendedprice;

    @Column(name = "freight")
    protected Double freight;

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

    public void setCustomerid(Customers customerid) {
        this.customerid = customerid;
    }

    public Customers getCustomerid() {
        return customerid;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setSalesperson(String salesperson) {
        this.salesperson = salesperson;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }

    public Orders getOrderid() {
        return orderid;
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

    public void setShippers_companyname(String shippers_companyname) {
        this.shippers_companyname = shippers_companyname;
    }

    public String getShippers_companyname() {
        return shippers_companyname;
    }

    public void setProductid(Products productid) {
        this.productid = productid;
    }

    public Products getProductid() {
        return productid;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setExtendedprice(String extendedprice) {
        this.extendedprice = extendedprice;
    }

    public String getExtendedprice() {
        return extendedprice;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getFreight() {
        return freight;
    }


}

