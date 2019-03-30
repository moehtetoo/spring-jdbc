package com.techfun.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techfun.jdbc.model.Employee;
import com.techfun.jdbc.repository.util.EmployeeRowMapper;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String insertTableSQL = "INSERT INTO employee(name,age,address) values(?,?,?)";
		jdbcTemplate.update(insertTableSQL, employee.getName(), employee.getAge(), employee.getAddress());
		System.out.println("Testing.....");
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

	@Override
	public List<Employee> getAllEmployee() {
		String selectSQL = "SELECT * FROM EMPLOYEE ORDER BY ID";
		return jdbcTemplate.query(selectSQL, new EmployeeRowMapper());
	}

}
