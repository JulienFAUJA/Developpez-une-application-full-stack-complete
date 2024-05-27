package com.openclassrooms.mddapi.models;



import jakarta.persistence.*;


/**
 * The type Abonnement model.
 */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Gets theme id.
     *
     * @return the theme id
     */
    public Integer getThemeId() {
        return themeId;
    }

    /**
     * Sets theme id.
     *
     * @param themeId the theme id
     */
    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }


    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    /**
     * Instantiates a new Abonnement model.
     */
    public AbonnementModel() {
    }

    /**
     * Instantiates a new Abonnement model.
     *
     * @param id      the id
     * @param themeId the theme id
     * @param userId  the user id
     */
    public AbonnementModel(Integer id, Integer themeId, Integer userId) {
        this.id=id;
        this.themeId = themeId;
        this.userId=userId;

    }

    /**
     * Instantiates a new Abonnement model.
     *
     * @param themeId the theme id
     * @param userId  the user id
     */
    public AbonnementModel(Integer themeId, Integer userId) {
        this.themeId = themeId;
        this.userId=userId;

    }



}
