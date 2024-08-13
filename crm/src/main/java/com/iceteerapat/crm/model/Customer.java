package com.iceteerapat.crm.model;

import com.iceteerapat.crm.enumuration.CustStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uniqueId;

    private String name;

    private String surName;

    @Column(unique = true)
    @NotEmpty(message = "Please inform your identification number")
    private Long id;

    private String address1;

    @Column(nullable = false)
    private String address2;

    private String phoneNo;

    @Enumerated(EnumType.STRING)
    private CustStatus custStatus;

    private String imageProfile;

    private String email;

    @NotEmpty(message = "Please inform your Date of Birth")
    private String dateOfBirth;

    @Column(unique = true)
    @NotEmpty
    private String custCode;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public CustStatus getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(CustStatus custStatus) {
        this.custStatus = custStatus;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", id=" + id +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", custStatus=" + custStatus +
                ", imageProfile='" + imageProfile + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", custCode='" + custCode + '\'' +
                '}';
    }
}
