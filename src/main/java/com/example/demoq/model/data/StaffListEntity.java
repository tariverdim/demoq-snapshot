package com.example.demoq.model.data;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "staff_list", schema = "sakila")
public class StaffListEntity {
    @Basic
    @Id
    @Column(name = "ID")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "zip code")
    private String zipCode;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "SID")
    private Long sid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffListEntity that = (StaffListEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(zipCode, that.zipCode) && Objects.equals(phone, that.phone) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, zipCode, phone, city, country, sid);
    }
}
