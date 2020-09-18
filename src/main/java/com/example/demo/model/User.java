package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data

public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname1")
    private String lastname1;

    @Column(name = "lastname2")
    private String lastname2;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
