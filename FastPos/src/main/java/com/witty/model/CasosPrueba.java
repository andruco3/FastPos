package com.witty.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "CasosPrueba")
public class CasosPrueba implements Serializable{
	
	private final int ESTADO_EXITOSO = 0;
	private final int ESTADO_FALLIDO = 1;
	private final int ESTADO_MODERADO = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombreCaso;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "usuario")
	private String usuarioAsignado;
	
	@Column(name = "observaciones")
	private String observaciones;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id= id;
	}

	public String getNombreCaso() {
		return nombreCaso;
	}

	public void setNombreCaso(String nombreCaso) {
		this.nombreCaso = nombreCaso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(String usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "casoPrueba")
	private Collection<ConexionesCasos> conexionesXCaso;
	

	
	
	
	
	
	

}
