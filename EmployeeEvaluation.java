
import models.EmployeeList;
import service.EmployeeDataCalculations;
import service.SetEmployeeDataService;
import utils.JsonUtils;

public class EmployeeEvaluation {

	public static void main(String[] args) {

		try {
//		set data
			SetEmployeeDataService setemployeeDataService = new SetEmployeeDataService();
			EmployeeList employeeList = setemployeeDataService.setEmployeeData();

//		do calculations
			EmployeeDataCalculations employeeDataCalculations = new EmployeeDataCalculations();
			employeeDataCalculations.doCalculations(employeeList);

//		print in format
			JsonUtils jsonUtils = new JsonUtils();
			jsonUtils.printObjectAndJson(employeeList);
		} catch (Exception e) {
			System.out.println("Error occurred in " + e.getClass());
			e.printStackTrace();
		}
	}
}
