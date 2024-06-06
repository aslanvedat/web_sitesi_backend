package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "contact_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token"})})
@SQLDelete(sql = "UPDATE contact_info SET deleted=true, deletion_token = id WHERE id=?")
public class ContactInfo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String addressName;

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
