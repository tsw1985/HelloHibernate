package com.gabrielglez.main.Facade;

import com.gabrielglez.main.command.PersonCommand;
import com.gabrielglez.main.model.Person;

public interface PersonFacade {
	
	public boolean createPerson(PersonCommand personCommand);
	public Person getPerson(Long id);

}
