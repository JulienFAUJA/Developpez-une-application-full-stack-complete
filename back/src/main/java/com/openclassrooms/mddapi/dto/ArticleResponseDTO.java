package com.openclassrooms.mddapi.dto;

public class ArticleResponseDTO {
	
	
	private String message;
    
    
	public ArticleResponseDTO() {
	}
	
	public ArticleResponseDTO(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
