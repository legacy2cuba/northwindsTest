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
        @AttributeOverride(name = "id", column = @Column(name = "supplierid"))
})
@Table(name = "suppliers")
@Entity(name = "northwindsTest$Suppliers")
public class Suppliers extends BaseIntegerIdEntity {
    @Column(name = "companyname", length = 40)
    protected String companyname;

    @Column(name = "contactname", length = 30)
    protected String contactname;

    @Column(name = "contacttitle", length = 30)
    protected String contacttitle;

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

    @Column(name = "phone", length = 24)
    protected String phone;

    @Column(name = "fax", length = 24)
    protected String fax;

    @Column(name = "homepage", length = 40000)
    protected String homepage;

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContacttitle(String contacttitle) {
        this.contacttitle = contacttitle;
    }

    public String getContacttitle() {
        return contacttitle;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getHomepage() {
        return homepage;
    }


}

