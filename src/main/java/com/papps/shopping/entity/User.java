package com.papps.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.papps.shopping.dto.request.UserRequestDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Data
@Entity
@Table(name = "\"User\"", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted","deletionToken"})})
@SQLDelete(sql = "UPDATE \"User\" SET deleted=yes, deletionToken = id WHERE id=?")
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "userName")
    private String name;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Column(name="deletionToken")
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
    private List<ContactInfo> contacts;//todo one to many

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;//todo one to many


}
