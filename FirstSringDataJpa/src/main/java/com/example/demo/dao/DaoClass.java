package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.sql.Delete;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.Employee;

@Repository
public class DaoClass {
	 @PersistenceContext
	    private EntityManager em;
	 public DaoClass() {
		// TODO Auto-generated constructor stub
	}
	 public Employee createEmployee(Employee emp)
	 {
		 emp=em.merge(emp);
		 return emp;
	 }
	 public String deleteEmp(int a)
	 {
		 Employee e=em.find(Employee.class,a );
		 if(e==null)
		 {
			 return "ID not present";
			 
		 }
		 else
		 {
			 
			 em.remove(e);
			 return "Successful";
		 }
	 }
	 public String UpdateEmployee(Employee emp) {
			Employee e=em.find(Employee.class,emp.getEid());
			if(e==null)
				return "Provided Employee id was not found";
			else
			{
				em.merge(emp);
				return "Updated Employee Info Successfully!";
			}
				
		}
	 public Employee getEmployeeById(int id) {
			
			return em.find(Employee.class,id);
		}
	 public List<Employee> getAllEmployee() {
			Query q=em.createQuery("select m from Employee m");
			List<Employee> emplist=q.getResultList();
			return emplist;
		}
	 
	 
}
