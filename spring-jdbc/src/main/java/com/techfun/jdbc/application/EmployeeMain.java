package com.techfun.jdbc.application;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.service.EmployeeService;

public class EmployeeMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService employeeService=(EmployeeService) ctx.getBean("employeeService");
		testCreateEmployee(employeeService);
//		testUpdateEmployee(employeeService);
//		testDeleteEmployee(employeeemployeeService);
		testGetAllEmployees(employeeService);
	}
	
	private static void testCreateEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setName("Moe Htet Oo");
		employee.setAge(21);
		employee.setAddress("Yangon");
		employeeService.createEmployee(employee);
		System.out.println("Process Successful completed!");
	}
	
	private static void testUpdateEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setName("Kyaw Kyaw");
		employee.setAddress("Monywa");
		employee.setId(1);
		employeeService.updateEmployee(employee);
		System.out.println("Process Successful completed!");
	}
	
	private static void testDeleteEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setId(2);
		employeeService.deleteEmployee(employee);
		System.out.println("Process Successful completed!");
	}
	
	private static void testGetAllEmployees(EmployeeService employeeService) {
		List<Employee> employeeList = employeeService.getAllEmployee();
		employeeList.forEach(employee -> System.out.println("Id : "+employee.getId()+" Name : "+employee.getName()
											+" Age : "+employee.getAge()+" Address : "+employee.getAddress()));
	}
}
