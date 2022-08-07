package com.offreapi.offreapi.api.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "demande")
public class Demande  {
	
	@Id
	private String id;

	private String idPost;
	
	private String idUser;
	
	private String description;
	
	private String telephone;
	
	private Date createDate;
	
	public Demande()	{
	}
	
	

	public Demande( String idUser, String idPost, String description, String telephone) {
		super();
		this.idPost = idPost;
		this.description = description;
		this.createDate = new Date();
		this.idUser = idUser;
		this.telephone = telephone;
	}
	
	


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}
	


	public String getIdUser() {
		return idUser;
	}



	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}



	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	
	
	
	
	
	
}
