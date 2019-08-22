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

	public Employee getById(int id) {
		// TODO Auto-generated method stub
		emp = new Employee();

		try {

			String sql = "SELECT * from tbl_emp where id =" + id;

			con = DBConnectionUtil.getDbConnection();

			stat = con.createStatement();
			resultset = stat.executeQuery(sql);

			while (resultset.next()) {

				emp.setId(resultset.getInt("id"));

				emp.setName(resultset.getString("name"));

				emp.setDob(resultset.getString("dob"));

				emp.setDepartment(resultset.getString("department"));

			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return emp;

	}

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
				emp.setId(resultset.getInt("id"));
				emp.setName(resultset.getString("name"));

				emp.setDob(resultset.getString("dob"));

				emp.setDepartment(resultset.getString("department"));

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

			// stat = con.createStatement();
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

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			String query = "DELETE FROM tbl_emp WHERE id = " + id + "";
			// stat = con.createStatement();
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

	@Override
	public boolean edit(Employee e) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			//String query = "UPDATE tbl_emp SET name = \"" + e.getName() + "\" WHERE id = " + e.getId();
			String query = "UPDATE tbl_emp SET name = ? , dob = ?, department = ? where id = ?";
			// stat = con.createStatement();
			System.out.println("trying to execute query...");
			
			prep = con.prepareStatement(query);
			prep.setString(1, e.getName());
			prep.setString(2, e.getDob());

			prep.setString(3, e.getDepartment());
			prep.setInt(4,e.getId());

			prep.executeUpdate();
			System.out.println("Executed and updated values successfully");
			flag = true;
		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return flag;

	}

	@Override
	public boolean isEmpPresent(Integer ids) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Integer id1 = null;
		try {

			String query = "SELECT id from tbl_emp where id = " + ids;

			System.out.println("query is " + query);
			//con = DBConnectionUtil.getDbConnection();

			stat = con.createStatement();
			resultset = stat.executeQuery(query);

			while (resultset.next()) {

				emp = new Employee();
			id1	 = resultset.getInt("id");
				 

				 

				 

			 
			}
			
			if(id1.equals(ids)) {
				
				return true;
				
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return false;
	}

}
