package com.example.demo.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class Controller {
	@Autowired
	private Repository repo;
	List<Student> students=new ArrayList<Student>();
	@RequestMapping(value="/new",method=RequestMethod.POST)
	List<Student> enterStudent(@RequestBody Student newStudent) {
		students.add(newStudent);
		repo.save(newStudent);
		return students;
	}
	@RequestMapping(value="/roll/{id}",method=RequestMethod.GET)
	Student searchStudent(@PathVariable int roll) {
		return repo.findById(roll).get();
		
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	List<Student> allStudents(){
		List<Student> students=(List<Student>) repo.findAll();
		return students;
	}
}
