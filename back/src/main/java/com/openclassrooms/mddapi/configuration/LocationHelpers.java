package com.openclassrooms.mddapi.configuration;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;

/**
 * Classe qui répertorie tous les chemins et répertoires nécessaires à l'application.
 */
public class LocationHelpers {
	
	public final static String ROOT_DIR = System.getProperty("user.dir");
	public final static String STATIC_DIR = LocationHelpers.GeneratePath("src,main,resources,static,images");
	public final static String ROOT_URI = "/api";
	public final static String STATIC_URI =  LocationHelpers.ROOT_URI+"/static";
	public final static String STATIC_URI_RECURSIVE =  LocationHelpers.ROOT_URI+"/static/**";
	public final static String AUTH_URI = LocationHelpers.ROOT_URI+"/auth";
	public final static String REGISTER_URI = LocationHelpers.AUTH_URI+"/register";
	public final static String LOGIN_URI = LocationHelpers.AUTH_URI+"/login";
	public final static String ME_URI = LocationHelpers.AUTH_URI+"/me";
	public final static String USER_URI = LocationHelpers.ROOT_URI+"/user";
	public final static String ARTICLES_URI = LocationHelpers.ROOT_URI+"/article/**";
	public final static String THEMES_URI = LocationHelpers.ROOT_URI+"/themes";
	public final static String IMAGES_URI_RECURSIVE = LocationHelpers.STATIC_DIR+"/**";
	public final static String BEARER_AUTH = "bearerAuth";
	
	@Value("${app.upload.dir}")
	public final static String uploadDir =STATIC_DIR;
	
	
	public static String GeneratePath(String folder_names) {
		String folder_tree_path = folder_names.replace(",", File.separator);
		String fullPath = ROOT_DIR+File.separator+folder_tree_path;
		return fullPath;
	}
	
	
	
	
	

}
