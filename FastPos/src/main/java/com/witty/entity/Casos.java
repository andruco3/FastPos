//package com.witty.entity;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "casos")
//public class Casos  implements Serializable{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	
//	private String descripcion;
//	private String fecha_ejecucion;
//	private String fecha_creacion;
//	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Collection<CasosPrueba> casosPrueba;
//	
//	
//	
//	
//	
//	
//
//}
