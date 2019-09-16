package service;

import models.Employee;
import models.EmployeeList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeDataCalculations {

	private static final int NUMBER_OF_QUARTERS = 4;

	public void doCalculations(EmployeeList employeeList) throws Exception {

		calculateAverageRating(employeeList);
		calculateExpectedSalary(employeeList);
		trackPerformance(employeeList);
		sortBasedOnAverageRating(employeeList);
	}

	private void sortBasedOnAverageRating(EmployeeList employeeList) throws Exception {

		List<Employee> listOfEmployees = employeeList.getEmployees();
		listOfEmployees.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee employee1, Employee employee2) {
				return employee1.getAverageRating().compareTo(employee2.getAverageRating());
			}
		});
		Collections.reverse(listOfEmployees);
		employeeList.setEmployees(listOfEmployees);
	}

	private void trackPerformance(EmployeeList employeeList) throws Exception {

		List<Employee> listOfEmployees = employeeList.getEmployees();

		if (listOfEmployees != null) {
			for (Employee employee : listOfEmployees) {
				if ((employee != null) && employee.getAverageRating() != null) {
					if (employee.getAverageRating() >= 7) {
						employee.setPerformanceType(Employee.PerformanceType.BEST.name());
					} else if ((employee.getAverageRating() >= 5) && (employee.getAverageRating() < 7)) {
						employee.setPerformanceType(Employee.PerformanceType.AVERAGE.name());
					} else {
						employee.setPerformanceType(Employee.PerformanceType.ON_TRACK.name());
					}
				} else {
					System.out.println("Employee data corrupt / unavailable");
				}
			}
		}
	}

	private void calculateExpectedSalary(EmployeeList employeeList) throws Exception {

		List<Employee> listOfEmployees = employeeList.getEmployees();

		if (listOfEmployees != null) {
			for (Employee employee : listOfEmployees) {
				Double increaseInSalary = 0D;
				if ((employee != null) && (employee.getCurrentSalary() != null) && (employee.getAverageRating() != null)) {
					increaseInSalary = employee.getCurrentSalary() * (employee.getAverageRating() / 100);
					employee.setExpectedSalary(employee.getCurrentSalary() + increaseInSalary);
				} else {
					System.out.println("Employee data corrupt / unavailable");
				}
			}
		}
	}

	private void calculateAverageRating(EmployeeList employeeList) throws Exception {

		List<Employee> listOfEmployees = employeeList.getEmployees();

		if (listOfEmployees != null) {
			for (Employee employee : listOfEmployees) {
				Double averageRating = 0D;
				if ((employee != null) && (employee.getRatingQ1() != null) && (employee.getRatingQ2() != null) &&
						(employee.getRatingQ3() != null) && (employee.getRatingQ4() != null)) {
					averageRating = Double.valueOf(employee.getRatingQ1() + employee.getRatingQ2() +
							employee.getRatingQ3() + employee.getRatingQ4());
					averageRating /= NUMBER_OF_QUARTERS;
					employee.setAverageRating(averageRating);
				} else {
					System.out.println("Employee data corrupt / unavailable");
				}
			}
		}
	}
}
