package com.papps.shopping.entity;

import java.util.List;

import com.papps.shopping.dto.request.UserRequestDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
private  Long id;

    @Column(name = "userName")
private String name;
    @Column(name = "userMail")
private String emailAddress;
    @Column(name = "password")
    private String password;

    public User() {

    }

    public User(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.emailAddress = userRequestDto.getMail();
        this.password=userRequestDto.getMail();
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.emailAddress= mail;
        this.password=password;
    }



    @OneToMany(cascade = CascadeType.ALL)
    private List<ContactInfo>contacts;//todo one to many

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order>orders;//todo one to many




}
