package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.papps.shopping.dto.request.UserRequestDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "\"User\"", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token", "mail"})})
@SQLDelete(sql = "UPDATE \"user\" SET deleted = true , deletion_token = id WHERE id=?")
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;


    private String mail;

    private String password;

    @JsonIgnore
    private String deletionToken;

    @JsonIgnore
    private boolean deleted;

    public User() {

    }

    public User(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.mail = userRequestDto.getMail();
        this.password = userRequestDto.getMail();
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }


    @OneToMany(cascade = CascadeType.ALL)
    private List<ContactInfo> contacts;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Role> roles;


}
