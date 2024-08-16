package com.example.demo.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerTitleEn;
    private String customerTitleTh;
    private String customerFirstNameEn;
    private String customerFirstNameTh;
    private String customerLastNameEn;
    private String customerLastNameTh;
    private String sex;
    private String occupationCode;
}
