package com.farmacenter.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farmacenter.modelo.Farmacia;
import com.farmacenter.service.IFarmaciaService;


@RestController
@RequestMapping
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST})
public class FarmaciaController {

	private IFarmaciaService iFarmaciaService;
	
	@Autowired
	public FarmaciaController(IFarmaciaService iFarmaciaService) {
		this.iFarmaciaService = iFarmaciaService;
	}
	
	// Metodo para obtener todas las farmacias
	@GetMapping("/farmacias")
	public ArrayList<Farmacia> getAllFarmacias(){
		return iFarmaciaService.getAll();
	}
	
	// Metodo para agregar una farmacia
	@PostMapping("/postfarmacia")
	public ResponseEntity<Farmacia> addFarmacia(@RequestBody Farmacia farmacia) {
		try {
			// Se invova la interfaz que agragará una farmacia
			iFarmaciaService.addFarmacia(farmacia);
			// Si la incerción de la farmacia es correcta retorna un mensaje
			return ResponseEntity.ok(farmacia);
		}catch (Exception e) {
			 // Manejar la excepción y realizar acciones necesarias
			return ResponseEntity.ok(farmacia);
		}
	}
	
	// Metodo para obtener una farmacia y ver el detalle
	@GetMapping("/farmacia/{id}")
	public ResponseEntity<Farmacia> getFarmacia(@PathVariable Long id) {
		 Farmacia farmacia = iFarmaciaService.getFaracia(id);
		 if (farmacia != null) {
			 return ResponseEntity.ok(farmacia);
		 } else {
			 return ResponseEntity.badRequest().build();
		 }
	}
	
	// Metodo para actualizar una farmacia
	@PutMapping("/putfarmacia")
	public ResponseEntity<String> putFarmacia(@RequestBody Farmacia farmacia) {
		try {
			// Se invoca la interfaz que actualizará la farmacia
			iFarmaciaService.updateFarmacia(farmacia);
			// Si la actualización de la farmacia es correcta retorna un mensaje
			return ResponseEntity.ok().body("Farmacia actualizada correctamente");
		}catch (Exception e) {
			 // Manejar la excepción y realizar acciones necesarias
		    String mensaje = "Error al actualizar la farmacia";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
		}
		
	}
	
	// Metodo para eliminar una farmacia
	@DeleteMapping ("/deletefarmacia/{id}")
	public ResponseEntity<String> deleteFarmacia(@PathVariable Long id) {
		try {
			// Se invova la interfaz que eliminará la farmacia
			iFarmaciaService.deleteFarmacia(id);
			// Si la eliminacaión de la farmacia es correcta retorna un mensaje
			return ResponseEntity.ok().body("Farmacia eliminada correctamente");
		}catch (Exception e) {
			 // Manejar la excepción y realizar acciones necesarias
		    String mensaje = "Error al eliminar la farmacia";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
		}
	}
}
