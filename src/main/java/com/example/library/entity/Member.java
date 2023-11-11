package com.example.library.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_Id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone_Number", nullable = false, unique = true)
    private String phone_Number;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "social_Number", nullable = false, unique = true)
    private String social_Number;

}
