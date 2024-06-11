package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "\"Order\"", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token"})})
@SQLDelete(sql = "UPDATE \"order\" SET deleted=true, deletion_token = id WHERE id=?")
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

/*    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;*/

    @OneToOne
    @JoinColumn(name = "contact_id")
    private ContactInfo contact;

    private float amaount;

    @JsonIgnore
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;

}
