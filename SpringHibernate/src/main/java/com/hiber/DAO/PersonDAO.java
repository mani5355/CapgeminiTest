package com.hiber.DAO;

import java.util.List;

import com.hiber.bean.Person;


public interface PersonDAO {

	public void save(Person person);
	
	public List<Person> view();
	
	
}
