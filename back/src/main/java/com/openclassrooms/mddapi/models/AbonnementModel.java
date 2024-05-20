package com.openclassrooms.mddapi.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ABONNEMENTS")
public class AbonnementModel {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer theme_id;
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(Integer theme_id) {
        this.theme_id = theme_id;
    }


       public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }



    public AbonnementModel() {
    }

    public AbonnementModel(Integer id, Integer theme_id, Integer user_id) {
        this.id=id;
        this.theme_id=theme_id;
        this.user_id=user_id;

    }

    public AbonnementModel(Integer theme_id, Integer user_id) {
        this.id=id;
        this.theme_id=theme_id;
        this.user_id=user_id;

    }



}
