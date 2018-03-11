public class Employee {

	PayrollDetails details;
	SystemManager userManager;
	EmployeeController econtroller;
	Week availability;
	private String userName;
	private String userPassword;
	private PayrollDetails payrollDetails;
	private Boolean passwordChangeRequired;
	private Week employeeAvailability;

	Employee(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability)
	{
		this.userName = userName;
		this.userPassword = userPassword;
		this.payrollDetails = p;
		this.passwordChangeRequired = passwordChangeRequired;
		this.employeeAvailability = employeeAvailability;
	}

	public Boolean clockIn() {

	}

	public Boolean clockOut() {
		// TODO - implement Employee.clockOut
		throw new UnsupportedOperationException();
	}

	public Boolean changePayroll(int accountNo, int sortCode) {
		// TODO - implement Employee.changePayroll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 * @param start
	 * @param end
	 * @param Description
	 */
	public void requestTimeOff(string type, Time start, Time end, String Description) {
		// TODO - implement Employee.requestTimeOff
		throw new UnsupportedOperationException();
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public PayrollDetails getPayrollDetails() {
	    return this.payrollDetails;
	}

	public void setPayrollDetails(PayrollDetails payrollDetails) {
		this.payrollDetails = payrollDetails;
	}

	public Boolean getPasswordChangeRequired() {
		return this.passwordChangeRequired;
	}

	public void setPasswordChangeRequired(Boolean passwordChangeRequired) {
		this.passwordChangeRequired = passwordChangeRequired;
	}

	public Week getEmployeeAvalibility() {
		return this.employeeAvailability;
	}

	public void setEmployeeAvalibility(Week employeeAvalibility) {
		this.employeeAvailability = employeeAvalibility;
	}
}