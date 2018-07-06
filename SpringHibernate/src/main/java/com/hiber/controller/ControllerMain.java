package com.hiber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hiber.DAO.PersonDAO;
import com.hiber.bean.Person;

@Controller
public class ControllerMain {
	
	@Autowired
	PersonDAO dao;
	
	@RequestMapping(value="/")
	public String index(){
		return "index";
	}

	@RequestMapping(value="/save")
	public String save(){
		return "save";
	}
	
	@RequestMapping(value="/view")
	public ModelAndView view(@ModelAttribute("person") Person person){
		ModelAndView mv = new ModelAndView();
		dao.save(person);
	    List<Person> list = dao.view();
		mv.addObject("list", list);
		mv.setViewName("view");
		return mv;
	}
	
}
