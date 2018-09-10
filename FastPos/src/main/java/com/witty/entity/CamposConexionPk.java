package com.witty.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;


  public class CamposConexionPk implements Serializable{
	
	

	private int idCampo;
	
	private int idConexion;
	
	CamposConexionPk(){}
	
	CamposConexionPk(int idCampo,int idConexion){
		this.idCampo=idCampo;
		this.idConexion=idConexion;
		
		
	}
	
	 public int getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public int getIdConexion() {
		return idConexion;
	}

	public void setIdConexion(int idConexion) {
		this.idConexion = idConexion;
	}

	@Override
	public int hashCode(){
		
		return super.hashCode();
		
	}
	
	 @Override
	public boolean equals(Object o){
		
		return true;
		
	}
	
	
	
	
	
	
	
}