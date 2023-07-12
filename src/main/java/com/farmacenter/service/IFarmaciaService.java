package com.farmacenter.service;

import java.util.ArrayList;

import com.farmacenter.modelo.Farmacia;

public interface IFarmaciaService {
	
	// Definimos las interfaces para el crud de farmacia
	ArrayList<Farmacia> getAll();
	void addFarmacia(Farmacia farmacia);
	Farmacia getFaracia(Long id);
	void updateFarmacia(Farmacia farmacia);
	void deleteFarmacia(Long id);
}
