package com.gabrielglez.main.FacadeImpl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielglez.main.HomeController;
import com.gabrielglez.main.DAO.PersonDAO;
import com.gabrielglez.main.Facade.PersonFacade;
import com.gabrielglez.main.command.PersonCommand;
import com.gabrielglez.main.model.Person;

//Con @Service definimos nuestra capa de negocio
//Con @Transactional definimos que todos estos metodos se ejecutaran
//como una transaccion
@Service
@Transactional
public class PersonFacadeImpl implements PersonFacade{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonFacadeImpl.class);
	
	//Inyectamos la capa de persistencia, el objeto DAO
	@Autowired
	private PersonDAO personDAO;

	@Override
	public Person getPerson(Long id) {
		return personDAO.getPerson(id);
	}

	@Override
	public boolean createPerson(PersonCommand personCommand) {
		logger.info("CREANDO PERSONA");
		return personDAO.createPerson(personCommandToPerson(personCommand));
	}

	//Este metodo en esta capa, obtiene el objeto del comando y lo pasamos al nuestro modelo
	//de datos , devolviendo un objeto Person.
	private Person personCommandToPerson(PersonCommand personCommand){
		Person person = new Person();
		person.setName(personCommand.getName());
		return person;
	}
	
	
}