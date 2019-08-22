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
	RequestDispatcher disp = null;

	public EmployeeController() {
		empdao = new EmployeeDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello from list");
		List<Employee> list = empdao.get();

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list);

		}

		request.setAttribute("list", list);

		disp = request.getRequestDispatcher("/views/employees.jsp");

		disp.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {

		case "list":
			list(request, response);
			break;

		case "delete":
			delete(request, response);
			break;

		case "edit":
			edit(request, response);
			System.out.println("edit clicked");
			break;

		default:
			list(request, response);
			break;
		}

	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String name = request.getParameter("name");

		int id = Integer.parseInt(request.getParameter("id"));

		System.out.println("ID IS " + id);

		Employee e = new Employee();
		e.setId(id);

		Employee safin = empdao.getById(id);

		request.setAttribute("employee", safin);

		System.out.println(safin.name);

		disp = request.getRequestDispatcher("/views/addEmp.jsp");

		disp.forward(request, response);

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String name = request.getParameter("name");

		 
		int id = Integer.parseInt(request.getParameter("id"));
		empdao.delete(id);
		System.out.println("deleted calleddd :)");
		request.setAttribute("deletedMsg", "Deleted the user");

		list(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 0;
		Employee emp = new Employee();
		try {

			id = Integer.parseInt(request.getParameter("id"));

			System.out.println("executed try");
		} catch (Exception e) {
		
			

		}
		
		emp.setId(id);
		
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String designation = request.getParameter("designation");

		
		emp.setName(name);
		emp.setDob(dob);
		emp.setDepartment(designation);
		System.out.println("generated id " + id);

		if (empdao.isEmpPresent(id)) {

			System.out.println("its present");

			empdao.edit(emp);
		} else {

			try {
				empdao.save(emp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message", "Saved the user");
		}

		/*
		 * try {
		 * 
		 * if (empdao.save(emp)) {
		 * 
		 * 
		 * 
		 * } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		//System.out.println("name is " + name);

		list(request, response);
	}

}
