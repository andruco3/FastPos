package com.witty.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "campos_conexion")
@IdClass(com.witty.entity.CamposConexionPk.class)
public class CamposConexion implements Serializable{
	

	@Id
	@Expose private int idCampo;
		
	
	//private int idConexion;

	
	@Column(name = "opcion")
	@Expose private String opcion;
	
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Conexion idConexion;

	public int getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public Conexion getIdConexion() {
		return idConexion;
	}

	public void setIdConexion(Conexion idConexion) {
		this.idConexion = idConexion;
	}
	


}
