package com.farmacenter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.farmacenter.modelo.Farmacia;
@Repository
public interface IFarmaciaRepository extends CrudRepository<Farmacia, Long>{

}
