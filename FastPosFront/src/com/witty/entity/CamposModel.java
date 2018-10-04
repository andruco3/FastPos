package com.witty.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;


public class CamposModel extends RecursiveTreeObject<CamposModel> implements Serializable  {
	
	@Expose protected int idCampo;
	@Expose protected String campo;
	@Expose protected String nombre;
	@Expose protected String clase;
	@Expose protected int longitud;
	@Expose protected String valor;
	@Expose protected boolean opciones;
	@Expose protected Collection<CamposModel> campos;
	
	


	public int getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}




	public String getCampo() {
		return campo;
	}




	public void setCampo(String campo) {
		this.campo = campo;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getClase() {
		return clase;
	}




	public void setClase(String clase) {
		this.clase = clase;
	}




	public int getLongitud() {
		return longitud;
	}




	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}




	public String getValor() {
		return valor;
	}




	public void setValor(String valor) {
		this.valor = valor;
	}




	public boolean isOpciones() {
		return opciones;
	}




	public void setOpciones(boolean opciones) {
		this.opciones = opciones;
	}




	public Collection<CamposModel> getCampos() {
		return campos;
	}




	public void setCampos(Collection<CamposModel> campos) {
		this.campos = campos;
	}




	public CamposModel(){}

}
