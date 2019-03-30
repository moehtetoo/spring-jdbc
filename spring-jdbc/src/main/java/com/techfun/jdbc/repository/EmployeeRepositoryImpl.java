package com.techfun.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techfun.jdbc.model.Employee;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String insertTableSQL = "INSERT INTO employee(name,age,address) values(?,?,?)";
		jdbcTemplate.update(insertTableSQL, employee.getName(), employee.getAge(), employee.getAddress());
	}

	@Override
	public void updateEmployee(Employee employee) {
		String updateTableSQL = "UPDATE employee SET name = ?,age = ?, address = ? WHERE id = ?";
		jdbcTemplate.update(updateTableSQL, employee.getName(), employee.getAge(), employee.getAddress(),
				employee.getId());
	}

	@Override
	public void deleteEmployee(Employee employee) {
		String deleteTableSQL = "DELETE from employee WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, employee.getId());
	}

}
