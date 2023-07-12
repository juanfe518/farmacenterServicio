package com.farmacenter.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="farmacia")
public class Farmacia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre_farmacia;
	private String direccion_farmacia;
	
	
	public Farmacia() {}
	
	public Farmacia(Long id, String nombre_farmacia, String direccion_farmacia) {
		super();
		this.id = id;
		this.nombre_farmacia = nombre_farmacia;
		this.direccion_farmacia = direccion_farmacia;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_farmacia() {
		return nombre_farmacia;
	}
	public void setNombre_farmacia(String nombre_farmacia) {
		this.nombre_farmacia = nombre_farmacia;
	}
	public String getDireccion_farmacia() {
		return direccion_farmacia;
	}
	public void setDireccion_farmacia(String direccion_farmacia) {
		this.direccion_farmacia = direccion_farmacia;
	}

	
}
