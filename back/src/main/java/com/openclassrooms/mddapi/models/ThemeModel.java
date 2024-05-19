package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "THEMES")
public class ThemeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
