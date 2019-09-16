package service;

import models.Employee;
import models.EmployeeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetEmployeeDataService {

	private static final int NUMBER_OF_QUARTERS = 4;

	public EmployeeList setEmployeeData() throws Exception {

		EmployeeList employeeList = new EmployeeList();
		List<Employee> listOfEmployees = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no. of employees:");
		int numberOfEmployees = scanner.nextInt();

		for (int i = 0; i < numberOfEmployees; i++) {

			Employee employee = new Employee();
			System.out.println("Enter data for " + (i + 1) + " employee:");
			setEmployeeName(employee, scanner);
			setCurrentSalaryOfEmployee(employee, scanner);
			setRatingsOfEmployee(employee, scanner);
			listOfEmployees.add(employee);
		}
		employeeList.setEmployees(listOfEmployees);
		return employeeList;
	}

	private void setRatingsOfEmployee(Employee employee, Scanner scanner) {

		int numberOfQuarters = NUMBER_OF_QUARTERS;
		int currentQuarter = 1;
		int rating;
		while(numberOfQuarters != 0) {
			System.out.print("Enter valid (1 to 10 only) " + employee.getName() + "'s rating for Q" +
					currentQuarter + ": ");
			rating = scanner.nextInt();
			if (validRating(rating)) {
				switch (currentQuarter) {
					case 1:
						employee.setRatingQ1(rating);
						break;
					case 2:
						employee.setRatingQ2(rating);
						break;
					case 3:
						employee.setRatingQ3(rating);
						break;
					case 4:
						employee.setRatingQ4(rating);
						break;
				}
				currentQuarter++;
				numberOfQuarters--;
			} else {
				System.out.print("Invalid rating given. ");
			}
		}
	}

	private void setCurrentSalaryOfEmployee(Employee employee, Scanner scanner) {

		System.out.print("Enter " + employee.getName() + "'s current salary: ");
		employee.setCurrentSalary(scanner.nextInt());
	}

	private void setEmployeeName(Employee employee, Scanner scanner) {

		System.out.print("Enter employee name: ");
		employee.setName(scanner.next());
	}

	private boolean validRating(int rating) {

		return (rating > 0 && rating <= 10);
	}
}