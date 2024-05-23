package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Data
@Entity
@Table(name = "\"Order\"", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted","deletionToken"})})
@SQLDelete(sql = "UPDATE \"Order\" SET deleted=yes, deletionToken = id WHERE id=?")
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product>products;//todo burasi one to many olacak

    @OneToOne
    @JoinColumn(name = "contact_id")
    private ContactInfo contact;

    @Column(name = "amount")
    private float amaount;

    @JsonIgnore
    @Column(name="deletionToken")
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;

}
