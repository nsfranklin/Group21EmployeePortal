public class PartTimeEmployee extends Employee {

	public PartTimeEmployee(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability){
		super(userName, userPassword, p, passwordChangeRequired,  employeeAvailability);

	}

	public void setAvalibility(Week avalibility) {
		this.employeeAvailability = avalibility;
	}
}