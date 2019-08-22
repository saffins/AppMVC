package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entities.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	boolean save(Employee e) throws SQLException;
	
 

	boolean delete(int id);
	
	boolean edit(Employee e);
	
	boolean isEmpPresent(Integer id);

}
