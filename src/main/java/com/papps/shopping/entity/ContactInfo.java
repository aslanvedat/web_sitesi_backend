package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

@Data
@Entity
@Table(name = "ContactInfo", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted","deletionToken"})})
@SQLDelete(sql = "UPDATE ContactInfo SET deleted=true, deletionToken = id WHERE id=?")
public class ContactInfo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "addressName")
    private String AddressName;

    @Column(name = "fullAddress")
    private String fullAddress;

    @Column(name = "postaCode")
    private String postaCode;

    @Column(name = "country")
    private String country;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "idNumber")
    private String idNumber;

    @Column(name = "isDefault")
    private Boolean isDefault;

    @JsonIgnore
    @Column(name="deletionToken")
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;
}
