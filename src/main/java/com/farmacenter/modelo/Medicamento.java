package com.farmacenter.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicamentos")
public class Medicamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre_medicamento;
	private int precio_medicamento;
	private String dosis_medicamento;
	private String efectos_medicamento;
	private String modo_uso_medicamento;
	private int farmacia_id;
	
	public Medicamento(){}	
	
	public Medicamento(Long id, String nombre_medicamento, int precio_medicamento, String dosis_medicamento, String efectos_medicamento, String modo_uso_medicamento, int farmacia_id) {
		this.id = id;
		this.nombre_medicamento = nombre_medicamento;
		this.precio_medicamento = precio_medicamento;
		this.dosis_medicamento = dosis_medicamento;
		this.efectos_medicamento = efectos_medicamento;
		this.modo_uso_medicamento = modo_uso_medicamento;
		this.farmacia_id = farmacia_id;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_medicamento() {
		return nombre_medicamento;
	}
	public void setNombre_medicamento(String nombre_medicamento) {
		this.nombre_medicamento = nombre_medicamento;
	}
	public int getPrecio_medicamento() {
		return precio_medicamento;
	}
	public void setPrecio_medicamento(int precio_medicamento) {
		this.precio_medicamento = precio_medicamento;
	}
	public String getDosis_medicamento() {
		return dosis_medicamento;
	}
	public void setDosis_medicamento(String dosis_medicamento) {
		this.dosis_medicamento = dosis_medicamento;
	}
	public String getEfectos_medicamento() {
		return efectos_medicamento;
	}
	public void setEfectos_medicamento(String efectos_medicamento) {
		this.efectos_medicamento = efectos_medicamento;
	}
	public String getModo_uso_medicamento() {
		return modo_uso_medicamento;
	}
	public void setModo_uso_medicamento(String modo_uso_medicamento) {
		this.modo_uso_medicamento = modo_uso_medicamento;
	}

	public int getFarmacia_id() {
		return farmacia_id;
	}

	public void setFarmacia_id(int farmacia_id) {
		this.farmacia_id = farmacia_id;
	}
}
