package com.gabrielglez.main.DAOImpl;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gabrielglez.main.DAO.PersonDAO;
import com.gabrielglez.main.model.Person;

//@Repository : Definimos nuestra capa de datos
@Repository
public class PersonDAOImpl implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	
	//Injectamos la session de hibernate
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createPerson(Person person) {

		Boolean saved = false;
		
		try{
			//abrimos la session de hibernate
			//y ponemos el objeto en estado de persistido
			sessionFactory.openSession().save(person);
			logger.info("PERSONA GUARDADA EN BASE DE DATOS");
			saved = true;
			
		}catch(HibernateException ex){
			logger.info("HA HABIDO UNA EXCEPCIÓN " + ex.toString());
			saved = false;
		}
		
		return saved;
	}

	@Override
	public Person getPerson(Long id) {
		
		Person person = null;
		
		try{
			
			logger.info("Obteniendo PERSONA con ID " + id);
			person = (Person)sessionFactory.openSession().get(Person.class, id);
			
		}catch(HibernateException ex){
			logger.info("HA HABIDO UNA EXCEPCIÓN " + ex.toString());
		}
		return person;
	}
}