package com.witty.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;


  public class ConexionesCasosPk implements Serializable{
	
	

	private int idCasosPrueba;
	
	private int idConexiones;
	
	 public int getIdCasosPrueba() {
		return idCasosPrueba;
	}

	public void setIdCasosPrueba(int idCasosPrueba) {
		this.idCasosPrueba = idCasosPrueba;
	}

	public int getIdConexiones() {
		return idConexiones;
	}

	public void setIdConexiones(int idConexiones) {
		this.idConexiones = idConexiones;
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