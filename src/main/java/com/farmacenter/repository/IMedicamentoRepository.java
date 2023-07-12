package com.farmacenter.repository;

import org.springframework.data.repository.CrudRepository;

import com.farmacenter.modelo.Medicamento;

public interface IMedicamentoRepository extends CrudRepository<Medicamento, Long>{
	
}
