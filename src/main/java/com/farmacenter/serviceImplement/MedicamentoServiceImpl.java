package com.farmacenter.serviceImplement;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacenter.modelo.Medicamento;
import com.farmacenter.repository.IMedicamentoRepository;
import com.farmacenter.service.IMedicamentoService;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService{
	
	@Autowired
	private IMedicamentoRepository iMedicamentoRepository;
	
	// Implementamos la interface para obtener los medicamentos
	@Override
	public ArrayList<Medicamento> getAllMedicamentos(){
		return (ArrayList<Medicamento>) iMedicamentoRepository.findAll();
	}
	
	// Implementamos la interface para agregar un medicamento
	@Override
	public void addMedicamento(Medicamento medicamento) {
		iMedicamentoRepository.save(medicamento);
	}
	
	// Implementamos la interface para obtener un unico medicamento
	@Override
	public Medicamento getMedicamento(Long id) {
		return iMedicamentoRepository.findById(id).orElse(null);
	}
	
	// Implementamos la interface para actualizar un medicamento
	@Override
	public void updateMedicamento(Medicamento medicamento) {
		Medicamento dbMedicamento = iMedicamentoRepository.findById(medicamento.getId()).orElse(null);
		if (dbMedicamento != null) {
			// Actualizar los campos necesarios del objeto Medicamento existente con los valores del objeto actualizado
			dbMedicamento.setNombre_medicamento(medicamento.getNombre_medicamento());
			dbMedicamento.setPrecio_medicamento(medicamento.getPrecio_medicamento());
			dbMedicamento.setDosis_medicamento(medicamento.getDosis_medicamento());
			dbMedicamento.setEfectos_medicamento(medicamento.getEfectos_medicamento());
			dbMedicamento.setModo_uso_medicamento(medicamento.getModo_uso_medicamento());
			
			// Guardar la actualización en la base de datos
			iMedicamentoRepository.save(dbMedicamento);
		}else {
			// Manejar el caso en el que el medicamento no exista 
	    	throw new NoSuchElementException("El medicamento con el ID " + medicamento.getId() + " no existe.");
		}
	}
	
	// Implementamos la interface para eliminar un medicamento
	@Override
	public void deleteMedicamento(Long id) {
		Medicamento dbMedicamento = iMedicamentoRepository.findById(id).orElse(null);
		if(dbMedicamento != null) {
			iMedicamentoRepository.delete(dbMedicamento);
		}else {
			throw new NoSuchElementException("El medicamento con el ID " + id+ " no existe.");
		}
	}
	
}
