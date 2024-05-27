package com.openclassrooms.mddapi.services.Interfaces;

/**
 * The interface Abonnement service.
 */
public interface IAbonnementService {

    /**
     * Toggle subscription string.
     *
     * @param id        the id
     * @param userEmail the user email
     * @return the string
     */
    String toggleSubscription(Integer id, String userEmail);

}




