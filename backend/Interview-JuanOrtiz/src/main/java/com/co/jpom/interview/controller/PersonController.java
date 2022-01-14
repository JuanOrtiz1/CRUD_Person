package com.co.jpom.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.jpom.interview.model.Person;
import com.co.jpom.interview.repository.PersonRepository;


@RestController // Defines that this class is a spring bean
@RequestMapping("/interview/v1/")
@Service	
public class PersonController {
	@Autowired
	PersonRepository personRepository;

	//Obtener toda la información.
	@GetMapping("/Person")
	public List<Person> getAllPerson(){
		return personRepository.findAll();
	}
	
	//Obtener toda la información de una persona por su ID
	@GetMapping("/Person/{id}")
	public Person getPersonByID(@PathVariable Long id) {
		return personRepository.findById(id).get();
	}
	
	//Realizar operación de insertar en la Base de datos.
	@PostMapping("/Person")
	public Person savePerson(@RequestBody Person persons){
		return personRepository.save(persons);
	}
	
	//Actualizar información
	@PutMapping("/Person/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person persons) {
		Person _persons = personRepository.findById(id).get();
		
		_persons.setFullname(persons.getFullname());
		_persons.setBirth(persons.getBirth());
		_persons.setFather(persons.getFather());
		_persons.setMother(persons.getMother());
		personRepository.save(_persons);
		return _persons;
	}
	
	//Eliminar registro por ID
	@DeleteMapping("/Person/{id}")
	public Person deletePersonById(@PathVariable Long id) {
		Person _persons = personRepository.findById(id).get();
		personRepository.deleteById(id);
		return _persons;
	}
	
	@DeleteMapping("/PersonList")
	public void deleteAll() {
		personRepository.deleteAll();
	}
}
