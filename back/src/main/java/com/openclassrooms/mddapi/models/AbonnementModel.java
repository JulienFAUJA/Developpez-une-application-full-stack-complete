package com.openclassrooms.mddapi.models;



import jakarta.persistence.*;


@Entity
@Table(name = "ABONNEMENTS")
public class AbonnementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "theme_id")
    private Integer themeId;
    @Column(name = "user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }


       public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    public AbonnementModel() {
    }

    public AbonnementModel(Integer id, Integer themeId, Integer userId) {
        this.id=id;
        this.themeId = themeId;
        this.userId=userId;

    }

    public AbonnementModel(Integer themeId, Integer userId) {
        this.themeId = themeId;
        this.userId=userId;

    }



}
