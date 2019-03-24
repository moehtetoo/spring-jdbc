package com.techfun.jdbc.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.service.EmployeeService;
import com.techfun.jdbc.service.RideService;

public class EmployeeMain {
	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService employeeService=(EmployeeService) ctx.getBean("employeeService");
		Employee employee= new Employee();
		testCreateEmployee(employee, employeeService);
		testUpdateEmployee(employee, employeeService);
		testCreateEmployee(employee, employeeService);
		testDeleteEmployee(employee, employeeService);
	}
	private static void testCreateEmployee(Employee employee,EmployeeService employeeService) {
		employee.setName("Moe Htet Oo");
		employee.setAge(21);
		employee.setAddress("Yangon");
		employeeService.createEmployee(employee);
		System.out.println("Process Successful completed!");
	}
	
	private static void testUpdateEmployee(Employee employee,EmployeeService employeeService) {
		employee.setName("Kyaw Kyaw");
		employee.setAddress("Monywa");
		employee.setId(1);
		employeeService.updateEmployee(employee);
		System.out.println("Process Successful completed!");
	}
	
	private static void testDeleteEmployee(Employee employee, EmployeeService employeeService) {
		employee.setId(2);
		employeeService.deleteEmployee(employee);
		System.out.println("Process Successful completed!");
	}
}
