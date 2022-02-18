package com.offreapi.offreapi.api.types;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.offreapi.offreapi.api.models.Message;

public class CreateMessageRequest {
	
	 @NotBlank
	private String senderId;

	 @NotBlank

	private String receiverId;

	 @NotBlank

	private String message ;
	 
	 
	 private String idDisscussion;

	
	public String getSenderId() {
		return senderId;
	}

	public void setSender(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdDisscussion() {
		return idDisscussion;
	}

	public void setIdDisscussion(String idDisscussion) {
		this.idDisscussion = idDisscussion;
	}

	
	

	
	
}
