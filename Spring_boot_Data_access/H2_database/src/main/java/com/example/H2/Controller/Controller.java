package com.example.H2.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.H2.dao.EmployeeDao;
import com.example.H2.model.Employee;

@RestController
@RequestMapping("/example")
public class Controller{
	@Autowired
	private EmployeeDao dao;
	
	@GetMapping("/get")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getCount() {
		return dao.findAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody List<Employee> emp) {
		dao.saveAll(emp);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Employee entity,@PathVariable Integer id) {
		entity.setId(id);
		dao.save(entity);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.GONE)
	public void delete(@PathVariable Integer id) {
		dao.deleteById(id);
	}
	
	@GetMapping("/getAllByQuery")
	public List<Employee> getByQuery() {
		return dao.findEmployee();
	}
	
}