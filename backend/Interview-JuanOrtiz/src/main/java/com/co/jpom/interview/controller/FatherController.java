package com.co.jpom.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.jpom.interview.model.Father;
import com.co.jpom.interview.repository.FatherRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/interview/v1/")
@Service	
public class FatherController {
	@Autowired
	FatherRepository FatherRepository;

	//Obtener toda la información.
	@GetMapping("/Father")
	public List<Father> getAllFather(){
		return FatherRepository.findAll();
	}
	
	//Obtener toda la información de una persona por su ID
	@GetMapping("/Father/{id}")
	public Father getFatherByID(@PathVariable Long id) {
		return FatherRepository.findById(id).get();
	}
	
	//Realizar operación de insertar en la Base de datos.
	@PostMapping("/Father")
	public Father saveFathers(@RequestBody Father Fathers){
		return FatherRepository.save(Fathers);
	}
	
	//Actualizar información
	@PutMapping("/Father/{id}")
	public Father updateFather(@PathVariable Long id, @RequestBody Father fathers) {
		Father _fathers = FatherRepository.findById(id).get();
		_fathers.setFullname(_fathers.getFullname());
		_fathers.setBirth(_fathers.getBirth());
		FatherRepository.save(_fathers);
		return _fathers;
	}
	
	//Eliminar registro por ID
	@DeleteMapping("/Father/{id}")
	public Father deleteFatherById(@PathVariable Long id) {
		Father _fathers = FatherRepository.findById(id).get();
		FatherRepository.deleteById(id);
		return _fathers;
	}
	
	@DeleteMapping("/FatherList")
	public void deleteAll() {
		FatherRepository.deleteAll();
	}
}