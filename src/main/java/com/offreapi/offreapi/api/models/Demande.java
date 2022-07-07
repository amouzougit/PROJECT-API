package com.offreapi.offreapi.api.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "demande")
public class Demande extends Post {

	private String idDiscussion;
	
	//private Date createDate;
	
	public Demande()	{
	}

	public Demande(String idUser, String id, String idCategorie, String description, Date createDate,
			Date modifiedDate) {
		super(idUser, id, idCategorie, description, createDate, modifiedDate);
		// TODO Auto-generated constructor stub
	}
	
	public Demande(String idUser,String idCategorie, String description
			) {
		super(idUser,idCategorie, description);
		// TODO Auto-generated constructor stub
	}



	public String getIdDiscussion() {
		return idDiscussion;
	}

	public void setIdDiscussion(String idDiscussion) {
		this.idDiscussion = idDiscussion;
	}

	
	

	@Override
	public String toString() {
		return "Demande [idDemande="  + ", idDiscussion=" + idDiscussion + ", createDate=" 
				+ "]";
	}
	
	
	
	
	
	
}
