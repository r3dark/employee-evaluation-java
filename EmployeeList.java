package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmployeeList {

	@JsonProperty("employees")
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeeList{" +
				"employees=" + employees +
				'}';
	}
}
