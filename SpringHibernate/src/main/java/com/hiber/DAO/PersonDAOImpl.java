package com.hiber.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiber.bean.Person;

@Transactional
@Repository
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Person person) {
		 sessionFactory.getCurrentSession().saveOrUpdate(person);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> view() {
		
		return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}

}
