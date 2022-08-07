package com.offreapi.offreapi.api.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
public class Message {
	

	@Id
	private String id;
	
	private String idDisscussion;
	
	private String text;
	
	private String image;

	private Date createAt;

	private String senderId;

	private String receiverId;

	private String message ;

    
	
	public Message() {
		
	}


	public Message(String id, String text, String image, Date createAt, String senderId,
			String receiverId, String message,String idDisscussion) {
		super();
		this.id = id;
		this.text = text;
		this.image = image;
		this.createAt = createAt;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
		this.idDisscussion = idDisscussion;

	}

	
	public Message( 
			String receiverId, String senderId, String message,String idDisscussion) {
		super();
	
		this.senderId = senderId;
		this.message = message;
		this.idDisscussion = idDisscussion;
		this.receiverId = receiverId;
		this.createAt = new Date();


	}


	public String getId() {
		return id;
	}


	public void setIdMessage(String id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getSenderId() {
		return senderId;
	}


	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}


	public String getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}


	public void setId(String id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "Message [id=" + id + ", idDisscussion=" + idDisscussion + ", text=" + text + ", image=" + image
				+ ", createAt=" + createAt + ", senderId=" + senderId + ", receiverId=" + receiverId + ", message="
				+ message + "]";
	}
	
	
	


	
	
	



	
	

}
