package com.datasys.springboothibernate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasys.springboothibernate.dao.PersonDao;
import com.datasys.springboothibernate.model.Person;

@RestController
public class PersonController {
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonDao dao;
	
	@PostMapping(value="/savePerson")
	public String savePerson(@RequestBody Person person)
	{
		if(null != person.getName()) {
		dao.saveUser(person);
		logger.info("Saved Person Name: " +person.getName());
		}
		return "success!!";
	}
	@GetMapping("/getAll")
	public List<Person> getALlPersons() {
		return dao.getPersons();
	}
}
