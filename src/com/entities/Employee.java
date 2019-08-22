package com.entities;

public class Employee {

	public Integer id;
	public String name;
	public String dob;
	public String department;
	

	public int getId() {
		return id;
	}

	public void setId(int age) {
		this.id = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [age=" + id + ", name=" + name + ", dob=" + dob + ", department=" + department + "]";
	}

}
