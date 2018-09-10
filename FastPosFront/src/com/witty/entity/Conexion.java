package com.witty.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Conexion extends RecursiveTreeObject<Conexion> implements Serializable  {



	public Conexion() {

	}
	
	@Expose private String nombreConexion;
	@Expose	private String direccionIp;
	@Expose	private String puerto;
	@Expose	private String tipo;
	@Expose	private String sense;
	@Expose	private String product;
	@Expose	private String message;
	@Expose	private Boolean state=true;
		private Collection<ConexionesCasos> conexionesXCaso;
	@Expose	private Collection<CamposConexion> camposConexion;
	
	public Conexion(String nombreConexion, String direccionIp, String puerto, String tipo, String sense, String product,
			String message, Collection<CamposConexion> camposConexion) {
		super();
		this.nombreConexion = nombreConexion;
		this.direccionIp = direccionIp;
		this.puerto = puerto;
		this.tipo = tipo;
		this.sense = sense;
		this.product = product;
		this.message = message;
		this.state=true;
		//this.conexionesXCaso = conexionesXCaso;
		this.camposConexion = camposConexion;
	
		
	}
	
	public Conexion(String nombreConexion, String direccionIp, String puerto, String tipo) {
		super();
		this.nombreConexion = nombreConexion;
		this.direccionIp = direccionIp;
		this.puerto = puerto;
		this.tipo = tipo;

	}

	public String getNombreConexion() {
		return nombreConexion;
	}

	public void setNombreConexion(String nombreConexion) {
		this.nombreConexion = nombreConexion;
	}

	public String getDireccionIp() {
		return direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSense() {
		return sense;
	}

	public void setSense(String sense) {
		this.sense = sense;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<ConexionesCasos> getConexionesXCaso() {
		return conexionesXCaso;
	}

	public void setConexionesXCaso(Collection<ConexionesCasos> conexionesXCaso) {
		this.conexionesXCaso = conexionesXCaso;
	}

	public Collection<CamposConexion> getCamposConexion() {
		return camposConexion;
	}

	public void setCamposConexion(Collection<CamposConexion> camposConexion) {
		this.camposConexion = camposConexion;
	}

	public Boolean getState() {
		if(state==null)
			state =true;
		return state;
	}

	public void setState(Boolean state) {
		if(this.state==null)
			this.state =true;
		this.state = state;
	}
	
	
	
	
	
	
}
