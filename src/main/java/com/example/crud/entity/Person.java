package com.example.crud.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "Person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN")
    @SequenceGenerator(name="ID_GEN", sequenceName="PLAYER_NUM", allocationSize=10)
    @Column(name = "p_id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "phone")
    String phone;
    @Column(name = "email")
    String email;
    @Column(name = "profile")
    String imgUrl;

}
