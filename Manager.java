import java.util.ArrayList;
import java.util.Random;

public class 	Manager extends Employee {


	public Manager(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability, String type){
		super(userName, userPassword, p , passwordChangeRequired, employeeAvailability, type);
	}

	public Manager(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability){
		super(userName, userPassword, p , passwordChangeRequired, employeeAvailability, "Manager");
	}

	public String addPartTimeEmployee(String userName, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability) {
		String userPassword = tempPassword();
		SystemManager.getInstance().addEmployee(new PartTimeEmployee(userName, userPassword, p, passwordChangeRequired, employeeAvailability));
		return userPassword;
	}

	public String addEmployee(String userName, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability) {
		String userPassword = tempPassword();
		SystemManager.getInstance().addEmployee(new Employee(userName, userPassword, p, passwordChangeRequired, employeeAvailability));
		return userPassword;
	}

	public Boolean setAvailability(Employee employee, Week availability) {
		// TODO - implement Manager.setAvailability
		throw new UnsupportedOperationException();
	}

	public String tempPassword(){
		Random r = new Random();
		int temp = 0;
		while(temp < 10000000) { //all temp passwords are to be 8 digit string of numbers
			temp = r.nextInt(99999999);
		}
		return Integer.toString(temp);
	}

	public void changeEmployeeToPartTimeEmployee(Employee nonPartTimeEmployee) {
		String userName = nonPartTimeEmployee.getUserName();
		String userPassword = nonPartTimeEmployee.getUserPassword();
		PayrollDetails PayrollDetails = nonPartTimeEmployee.getPayrollDetails();
		Boolean passwordChangedRequired = nonPartTimeEmployee.getPasswordChangeRequired();
		Week employeeAvailability = nonPartTimeEmployee.getEmployeeAvalibility();
		SystemManager.getInstance().removeEmployee(userName);
		SystemManager.getInstance().addEmployee(new PartTimeEmployee(userName, userPassword, PayrollDetails, passwordChangedRequired, employeeAvailability));
	}

	public void changePartTimeEmployeeToEmployee(PartTimeEmployee PartTimeEmployee) {
		String userName = PartTimeEmployee.getUserName();
		String userPassword = PartTimeEmployee.getUserPassword();
		PayrollDetails PayrollDetails = PartTimeEmployee.getPayrollDetails();
		Boolean passwordChangedRequired = PartTimeEmployee.getPasswordChangeRequired();
		Week employeeAvailability = PartTimeEmployee.getEmployeeAvalibility();
		SystemManager.getInstance().removeEmployee(userName);
		SystemManager.getInstance().addEmployee(new Employee(userName, userPassword, PayrollDetails, passwordChangedRequired, employeeAvailability));
	}

	public void approveRequest(Requests a) {
		SystemManager.getInstance().removeRequest(a);
		SystemManager.getInstance().addApprovedRequest(a);
	}

}