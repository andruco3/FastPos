package com.witty.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;;

@Entity
@Table(name = "user")
public class Usuario  implements Serializable{
	
	@Id
	private String usuario;
	private String name;
	private String apellido;
	private String Password;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario", joinColumns = @JoinColumn(name = "usuario"),
		inverseJoinColumns = @JoinColumn(name = "id"))
	private Collection<Proyecto> proyecto;
	 

}
