package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ContactInfo", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletionToken"})})
@SQLDelete(sql = "UPDATE ContactInfo SET deleted=true, deletionToken = id WHERE id=?")
public class ContactInfo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String AddressName;

    private String fullAddress;

    private String postaCode;

    private String country;

    private String phoneNumber;

    // private String idNumber;

    private Boolean isDefault;

    @JsonIgnore
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;
}
