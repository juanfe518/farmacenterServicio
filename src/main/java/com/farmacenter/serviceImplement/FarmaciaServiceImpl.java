package com.farmacenter.serviceImplement;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacenter.modelo.Farmacia;
import com.farmacenter.repository.IFarmaciaRepository;
import com.farmacenter.service.IFarmaciaService;

@Service
public class FarmaciaServiceImpl implements IFarmaciaService{
	
	@Autowired
	private IFarmaciaRepository iFarmaciaRepository;
	
	// Implementamos la interface para obtener las farmacia
	@Override
	public ArrayList<Farmacia> getAll(){
		return (ArrayList<Farmacia>) iFarmaciaRepository.findAll();
	}
	
	// Implementamos la interface para agregar una farmacia
	@Override
	public void addFarmacia(Farmacia farmacia) {
		iFarmaciaRepository.save(farmacia);
	}
	
	// Implementamos la interface para obtener una unica farmacia
	@Override
	public Farmacia getFaracia(Long id) {
		return iFarmaciaRepository.findById(id).orElse(null);
	}
	
	// Implementamos la interface para actualizar una farmacia
	@Override
	public void updateFarmacia(Farmacia farmacia) {
		Farmacia DbFarmacia = iFarmaciaRepository.findById(farmacia.getId()).orElse(null);
		if (DbFarmacia != null) {
	        // Actualizar los campos necesarios del objeto Farmacia existente con los valores del objeto actualizado
			DbFarmacia.setNombre_farmacia(farmacia.getNombre_farmacia());
			DbFarmacia.setDireccion_farmacia(farmacia.getDireccion_farmacia());

	        // Guardar la actualización en la base de datos
	        iFarmaciaRepository.save(DbFarmacia);
	    } else {
	        // Manejar el caso en el que la farmacia no exista 
	    	throw new NoSuchElementException("La farmacia con el ID " + farmacia.getId() + " no existe.");
	    }
	}
	
	// Implementamos la interface para eliminar una farmacia
	@Override
	public void deleteFarmacia(Long id){
		Farmacia DbFarmacia = iFarmaciaRepository.findById(id).orElse(null);
		if (DbFarmacia != null) {	   
	        iFarmaciaRepository.delete(DbFarmacia);
	    } else {
	    	throw new NoSuchElementException("La farmacia con el ID " + id+ " no existe.");
	    }
	}
}
