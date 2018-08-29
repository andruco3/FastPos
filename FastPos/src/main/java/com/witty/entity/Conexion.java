package com.witty.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "conexion")
public class Conexion  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public Conexion(String name, String direccionIp, String tipo) {
		
		this.nombreConexion=name;
		this.direccionIp=direccionIp;
		this.tipo=tipo;
		
		
		
	}
	
public Conexion() {
		
		
		
	}
	
	
	@Column(name = "nombre")
	private String nombreConexion;
	
	
	@Column(name = "direccion_IP")
	private String direccionIp;
	
	
	@Column(name = "puerto")
	private String puerto;

	
	@Column(name = "tipo")
	private String tipo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "conexion")
	private Collection<ConexionesCasos> conexionesXCaso;
	

	
	
	
	
	
	

}
