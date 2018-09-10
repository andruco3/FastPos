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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "conexion")
@XmlRootElement
public class Conexion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Conexion(String name, String direccionIp, String tipo) {

		this.nombreConexion = name;
		this.direccionIp = direccionIp;
		this.tipo = tipo;

	}

	public Conexion() {

	}

	@Column(name = "nombre")
	@Expose private String nombreConexion;

	@Column(name = "direccion_IP")
	@Expose private String direccionIp;

	@Column(name = "puerto")
	@Expose private String puerto;

	@Column(name = "tipo")
	@Expose private String tipo;

	@Column(name = "sense")
	@Expose private String sense;

	@Column(name = "product")
	@Expose private String product;

	@Column(name = "message")
	@Expose private String message;

	@Column(name = "state")
	@Expose private Boolean state;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "conexion")
	private Collection<ConexionesCasos> conexionesXCaso;

	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "idConexion")
	@JoinColumn(name="CONEXION_ID") 
	@Expose private Collection<CamposConexion> camposConexion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}
