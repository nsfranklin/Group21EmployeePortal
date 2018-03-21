public class PartTimeEmployee extends Employee {

	public PartTimeEmployee(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability, String type){
		super(userName, userPassword, p, passwordChangeRequired,  employeeAvailability, type);
	}

	public PartTimeEmployee(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability){
		super(userName, userPassword, p, passwordChangeRequired,  employeeAvailability, "PartTimeEmployee");
	}

	public void setAvalibility(Week avalibility) {
		this.employeeAvailability = avalibility;
	}
}