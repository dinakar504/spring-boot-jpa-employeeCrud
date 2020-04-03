package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Employee;
import com.example.demo.service.ServiceImpl;

@RestController

public class RestController1 
{
@Autowired
ServiceImpl serviceobj;

//Create Employee
@PostMapping("/EmployeeCreation")
 public Employee EmployeeCreation(@RequestBody Employee emp)
 {
	return serviceobj.EmployeeCreation(emp);
 }

//Get Particular Employee Data
@GetMapping("/GetEmployee/{id}")
private Employee getEmployee(@PathVariable("id") int id) 
{
return serviceobj.getEmployeeById(id);
}

//Get All Employees Data
@GetMapping("/GetAllEmployees")
private List<Employee> getAllEmployee() 
{
return serviceobj.getAllEmployee();
}

//Updating Employee data
@PutMapping("/UpdateEmployee")
public String UpdateEmployee(@RequestBody Employee emp)
{
	return serviceobj.UpdateEmployee(emp);
}

//Deleting Employee
@DeleteMapping("/DeleteEmployee/{id}")
private String delEmp(@PathVariable("id") int id) 
{
	return serviceobj.delete(id);
}

}