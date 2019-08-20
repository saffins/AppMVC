package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entities.Employee;
import com.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con = null;
	Statement stat = null;
	ResultSet resultset = null;
	List<Employee> list = null;
	Employee emp = null;
	PreparedStatement prep = null;

	public List<Employee> get() {
		// TODO Auto-generated method stub
		list = new ArrayList<Employee>();

		try {

			String sql = "SELECT * from tbl_emp";

			con = DBConnectionUtil.getDbConnection();

			stat = con.createStatement();
			resultset = stat.executeQuery(sql);

			while (resultset.next()) {

				emp = new Employee();
				emp.setAge(resultset.getInt("id"));
				System.out.println(resultset.getInt("id"));
				emp.setName(resultset.getString("name"));
				System.out.println(resultset.getString("name"));

				emp.setDob(resultset.getString("dob"));
				System.out.println(resultset.getString("dob"));

				emp.setDepartment(resultset.getString("department"));
				System.out.println(resultset.getString("department"));

				list.add(emp);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;

	}

	@Override
	public boolean save(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String query = "INSERT INTO tbl_emp(name,dob,department)VALUES('" + e.getName() + "', '" + e.getDob()
					+ "','" + e.getDepartment() + "')";
			con = DBConnectionUtil.getDbConnection();

			//stat = con.createStatement();
			System.out.println("trying to execute query...");
			prep = con.prepareStatement(query);
			prep.executeUpdate();
			System.out.println("Executed :)");
			flag = true;
		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return flag;

	}

}
