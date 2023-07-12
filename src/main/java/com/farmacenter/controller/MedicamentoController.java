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

import com.farmacenter.modelo.Medicamento;
import com.farmacenter.service.IMedicamentoService;

@RestController
@RequestMapping
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST})
public class MedicamentoController {
	
	private IMedicamentoService iMedicamentoService;
	
	@Autowired
	public MedicamentoController(IMedicamentoService iMedicamentoService) {
		this.iMedicamentoService = iMedicamentoService;
	}
	
	// Metodo para obtener todas los medicamentos
	@GetMapping("/medicamentos")
	public ArrayList<Medicamento> getAllMedicamentos(){
		return iMedicamentoService.getAllMedicamentos();
	}
	
	// Metodo para agregar un medicamento
	@PostMapping("/postmedicamento")
	public ResponseEntity<String> addMedicamento(@RequestBody Medicamento medicamento){
		try {
			// Se invova la interfaz que agragará un medicamento
			iMedicamentoService.addMedicamento(medicamento);
			
			// Si la incerción del medicamento es correcta retorna un mensaje
			return ResponseEntity.ok().body("Medicamento agregado correctamente");
		}catch(Exception e) {
			String mensaje = "Error al agregar el medicamento";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
		}
	}
	
	// Metodo para obtener un medicamento y ver el detalle
	@GetMapping("/medicamento/{id}")
	public ResponseEntity<Medicamento> getMedicamento(@PathVariable Long id){
		Medicamento medicamento = iMedicamentoService.getMedicamento(id);
		if(medicamento != null) {
			return ResponseEntity.ok(medicamento);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// Metodo para actualizar un medicamento
	@PutMapping("/putmedicamento")
	public ResponseEntity<String> putFarmacia(@RequestBody Medicamento medicamento){
		try {
			// Se invoca la interfaz que actualizará el medicamento
			iMedicamentoService.updateMedicamento(medicamento);
			
			// Si la actualización del medicamento es correcto retorna un mensaje
			return ResponseEntity.ok().body("Medicamento actualizado correctamente");
		}catch(Exception e) {
			// Manejar la excepción y realizar acciones necesarias
		    String mensaje = "Error al actualizar el medicamento";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
		}
	}
	
	// Metodo para eliminar un medicamento
	@DeleteMapping ("/deletemedicamento/{id}")
	public ResponseEntity<String> deleteMedicamento(@PathVariable Long id){
		try {
			// Se invova la interfaz que eliminará el medicamento
			iMedicamentoService.deleteMedicamento(id);
			// Si la eliminacaión del medicamento es correcta retorna un mensaje
			return ResponseEntity.ok().body("Medicamento eliminado correctamente");
		}catch(Exception e) {
			// Manejar la excepción y realizar acciones necesarias
		    String mensaje = "Error al eliminar el medicamento";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
		}
	}
	
}
