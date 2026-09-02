package com.practice.SpringBootTesting.Entites;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(precision = 19,scale = 2)
    private Double salary;

}
