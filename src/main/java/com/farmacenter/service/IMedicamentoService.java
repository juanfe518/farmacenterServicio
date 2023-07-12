package com.farmacenter.service;

import java.util.ArrayList;

import com.farmacenter.modelo.Medicamento;

public interface IMedicamentoService {
	// Definimos las interfaces para el crud de medicamento
	ArrayList<Medicamento> getAllMedicamentos();
	void addMedicamento(Medicamento medicamento);
	Medicamento getMedicamento(Long id);
	void updateMedicamento(Medicamento medicamento);
	void deleteMedicamento(Long id);
}
