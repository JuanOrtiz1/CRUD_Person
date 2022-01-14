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
import com.co.jpom.interview.model.Mother;
import com.co.jpom.interview.repository.MotherRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/interview/v1/")
@Service	
public class MotherController {
	@Autowired
	MotherRepository motherRepository;

	//Obtener toda la información.
	@GetMapping("/Mother")
	public List<Mother> getAllMother(){
		return motherRepository.findAll();
	}
	
	//Obtener toda la información de una persona por su ID
	@GetMapping("/Mother/{id}")
	public Mother getMotherByID(@PathVariable Long id) {
		return motherRepository.findById(id).get();
	}
	
	//Realizar operación de insertar en la Base de datos.
	@PostMapping("/Mother")
	public Mother saveMothers(@RequestBody Mother mothers){
		return motherRepository.save(mothers);
	}
	
	//Actualizar información
	@PutMapping("/Mother/{id}")
	public Mother updateMother(@PathVariable Long id, @RequestBody Mother mothers) {
		Mother _mothers = motherRepository.findById(id).get();
		_mothers.setFullname(_mothers.getFullname());
		_mothers.setBirth(_mothers.getBirth());
		motherRepository.save(_mothers);
		return _mothers;
	}
	
	//Eliminar registro por ID
	@DeleteMapping("/Mother/{id}")
	public Mother deleteMotherById(@PathVariable Long id) {
		Mother _mothers = motherRepository.findById(id).get();
		motherRepository.deleteById(id);
		return _mothers;
	}
	
	@DeleteMapping("/MotherList")
	public void deleteAll() {
		motherRepository.deleteAll();
	}
}