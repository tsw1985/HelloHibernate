package com.gabrielglez.main.DAO;

import com.gabrielglez.main.model.Person;

public interface PersonDAO {
	
	public boolean createPerson(Person person);
	public Person getPerson(Long id);

}
