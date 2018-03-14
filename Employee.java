import java.time.LocalTime;

public class Employee {

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
		// TODO - implement Employee.clockIn
		return true;
	}

	public Boolean clockOut() {
		// TODO - implement Employee.clockOut
		throw new UnsupportedOperationException();
	}

	public void changePayroll(int accountNo, int sortCode) {
        setPayrollDetails(new PayrollDetails(accountNo,sortCode));
	}

	public void requestTimeOff(String type, int start, int end, String Description) {
        int dateMade = ;
        int timeMade = getTime();
        int requestID = ;
        String timeOffType = type;
        int startDate = start;
        int endDate = end;
        String description = Description;
        String userName = this.getUserName();
	    timeOff temp = new timeOff(dateMade,timeMade,requestID,timeOffType,startDate,endDate,description,userName);
	    SystemManager.addRequest(temp);
	}

    public int getTime(){
        String[] temp = LocalTime.now().toString().split(":");
        int local = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        return local;
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

	public void setPasswordChangeRequired(Boolean passwordChangeRequired) { this.passwordChangeRequired = passwordChangeRequired; }

	public Week getEmployeeAvalibility() {
		return this.employeeAvailability;
	}

	public void setEmployeeAvalibility(Week employeeAvalibility) {
		this.employeeAvailability = employeeAvalibility;
	}
}