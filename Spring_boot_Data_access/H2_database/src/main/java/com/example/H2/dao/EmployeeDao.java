package com.example.H2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.H2.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	@Query("select T from Employee T")
	public List<Employee> findEmployee();
}
