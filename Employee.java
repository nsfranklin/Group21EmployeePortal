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

	public Boolean clockIn() {
		// TODO - implement Employee.clockIn
		throw new UnsupportedOperationException();
	}

	public Boolean clockOut() {
		// TODO - implement Employee.clockOut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param accountNo
	 * @param sortCode
	 */
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

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	/**
	 * 
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public PayrollDetails getPayrollDetails() {
		return this.payrollDetails;
	}

	/**
	 * 
	 * @param payrollDetails
	 */
	public void setPayrollDetails(PayrollDetails payrollDetails) {
		this.payrollDetails = payrollDetails;
	}

	public Boolean getPasswordChangeRequired() {
		return this.passwordChangeRequired;
	}

	/**
	 * 
	 * @param passwordChangeRequired
	 */
	public void setPasswordChangeRequired(Boolean passwordChangeRequired) {
		this.passwordChangeRequired = passwordChangeRequired;
	}

	public Week getEmployeeAvalibility() {
		// TODO - implement Employee.getEmployeeAvalibility
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param employeeAvalibility
	 */
	public void setEmployeeAvalibility(Week employeeAvalibility) {
		// TODO - implement Employee.setEmployeeAvalibility
		throw new UnsupportedOperationException();
	}

}