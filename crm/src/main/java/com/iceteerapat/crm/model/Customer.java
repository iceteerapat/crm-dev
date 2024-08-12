package com.iceteerapat.crm.model;

import com.iceteerapat.crm.enumuration.CustStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.swing.*;

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

    private CustStatus custStatus;

    private String imageProfile;

    private String email;

    @NotEmpty(message = "Please inform your Date of Birth")
    private String dateOfBirth;

    @Column(unique = true)
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String custCode;


}
