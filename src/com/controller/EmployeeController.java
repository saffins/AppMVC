package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAOImpl;
import com.entities.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	EmployeeDAOImpl empdao = null;
	

	public EmployeeController() {
		empdao = new EmployeeDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Employee> list = empdao.get();
		
		for(int i = 0;i<list.size();i++) {
			
			System.out.println(list);
			
		}
		
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/views/employees.jsp");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String designation = request.getParameter("designation");
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDob(dob);
		emp.setDepartment(designation);
		
		try {
			empdao.save(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("name is " + name);

	
	}

}
