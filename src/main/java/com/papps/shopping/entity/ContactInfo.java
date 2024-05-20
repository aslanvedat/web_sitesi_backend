package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ContactInfo")
public class ContactInfo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

@Column(name = "name")
    private String name;

@Column(name = "addressName")
private String AddressName;

@Column(name = "fullAddress")
    private  String fullAddress;

@Column(name = "postaCode")
    private  String postaCode;

@Column(name = "country")
private String country;

@Column(name = "phoneNumber")
    private  String phoneNumber;

@Column(name = "idNumber")
    private  String idNumber;

@Column(name = "isDefault")
    private Boolean isDefault;
}
