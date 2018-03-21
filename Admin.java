import java.util.Random;

public class Admin extends Manager {

	public Admin(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability, String type){
		super(userName, userPassword, p , passwordChangeRequired, employeeAvailability, type);
	}


	public String resetEmployeePassword(Employee user) {
		user.setPasswordChangeRequired(false);
		String tempPassword = tempPassword();
		user.setUserPassword(tempPassword);
		return tempPassword;
	}

	public void markEmployeeAsManager(Employee employee) { //will work on employee and parTimeEmployee
		String userName = employee.getUserName();
		String userPassword = employee.getUserPassword();
		PayrollDetails PayrollDetails = employee.getPayrollDetails();
		Boolean passwordChangedRequired = employee.getPasswordChangeRequired();
		Week employeeAvailability = employee.getEmployeeAvalibility();
	    SystemManager.getInstance().removeEmployee(userName);
	    SystemManager.getInstance().addEmployee(new Manager(userName, userPassword, PayrollDetails, passwordChangedRequired, employeeAvailability));
	}


	public void unmarkEmployeeAsManager(Manager manager) {
        String userName = manager.getUserName();
        String userPassword = manager.getUserPassword();
        PayrollDetails PayrollDetails = manager.getPayrollDetails();
        Boolean passwordChangedRequired = manager.getPasswordChangeRequired();
        Week employeeAvailability = manager.getEmployeeAvalibility();
        SystemManager.getInstance().removeEmployee(userName);
        SystemManager.getInstance().addEmployee(new Employee(userName, userPassword, PayrollDetails, passwordChangedRequired, employeeAvailability));
	}


	public void setScheduleRules(Week rules) {
		SystemManager.getInstance().setCurrentSchedule(rules);
	}
}