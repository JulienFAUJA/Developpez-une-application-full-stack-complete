package com.openclassrooms.mddapi.models;



import jakarta.persistence.*;


@Entity
@Table(name = "ABONNEMENTS")
public class AbonnementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer theme_id;
    @Column(name = "user_id")
    private Integer userId;

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


       public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    public AbonnementModel() {
    }

    public AbonnementModel(Integer id, Integer theme_id, Integer userId) {
        this.id=id;
        this.theme_id=theme_id;
        this.userId=userId;

    }

    public AbonnementModel(Integer theme_id, Integer userId) {
        this.theme_id=theme_id;
        this.userId=userId;

    }



}
