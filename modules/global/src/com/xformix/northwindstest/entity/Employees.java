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
        @AttributeOverride(name = "id", column = @Column(name = "employeeid"))
})
@Table(name = "employees")
@Entity(name = "northwindsTest$Employees")
public class Employees extends BaseIntegerIdEntity {
    @Column(name = "lastname", length = 20)
    protected String lastname;

    @Column(name = "firstname", length = 10)
    protected String firstname;

    @Column(name = "title", length = 30)
    protected String title;

    @Column(name = "titleofcourtesy", length = 25)
    protected String titleofcourtesy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthdate")
    protected Date birthdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hiredate")
    protected Date hiredate;

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

    @Column(name = "homephone", length = 24)
    protected String homephone;

    @Column(name = "extension", length = 4)
    protected String extension;

    @Column(name = "photo")
    protected byte[] photo;

    @Column(name = "notes", length = 40000)
    protected String notes;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsto")
    protected Employees reportsto;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitleofcourtesy(EnumTitleofcourtesy titleofcourtesy) {
        this.titleofcourtesy = titleofcourtesy == null ? null : titleofcourtesy.getId();
    }

    public EnumTitleofcourtesy getTitleofcourtesy() {
        return titleofcourtesy == null ? null : EnumTitleofcourtesy.fromId(titleofcourtesy); 
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getHiredate() {
        return hiredate;
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

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setReportsto(Employees reportsto) {
        this.reportsto = reportsto;
    }

    public Employees getReportsto() {
        return reportsto;
    }


}

