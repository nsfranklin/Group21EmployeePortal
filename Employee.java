import java.io.IOException;
import java.time.LocalTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private String userName;
	private String userPassword;
	private PayrollDetails payrollDetails;
	private Boolean passwordChangeRequired;
	protected Week employeeAvailability;
	private String employeeType;

	public Employee(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability, String type)
	{
		this.userName = userName;
		this.userPassword = userPassword;
		this.payrollDetails = p;
		this.passwordChangeRequired = passwordChangeRequired;
		this.employeeAvailability = employeeAvailability;
		this.employeeType = type;
	}



	public Employee(String userName, String userPassword, PayrollDetails p, Boolean passwordChangeRequired, Week employeeAvailability)
	{
		this.userName = userName;
		this.userPassword = userPassword;
		this.payrollDetails = p;
		this.passwordChangeRequired = passwordChangeRequired;
		this.employeeAvailability = employeeAvailability;
		this.employeeType = "Employee";
	}

	public void clockIn() {
		SystemManager.getInstance().addClockedHours(new ClockedHours(this.getUserName(), this.getCurrentTime()));
	}

	public void clockOut() {
		for(int i = 0 ; i < SystemManager.getInstance().getClockedHoursList().size() ; i++){
			if(SystemManager.getInstance().getClockedHoursList().get(i).getUserName().equals(this.userName)){
				SystemManager.getInstance().getClockedHoursList().get(i).clockOut();
			}
		}
	}

	public void changePayroll(String accountNo, String sortCode) {
        setPayrollDetails(new PayrollDetails(accountNo,sortCode));
	}

	public void requestTimeOff(String type, Date start, Date end, String Description) throws IOException {
        Date dateMade = this.getCurrentDate();
        int timeMade = this.getCurrentTime();
        String timeOffType = type;
        Date startDate = start;
        Date endDate = end;
        String description = Description;
        String userName = this.getUserName();
	    timeOff temp = new timeOff(dateMade,timeMade,timeOffType,startDate,endDate,description,userName);
	    SystemManager.getInstance().addRequest(temp);
	}

    public int getCurrentTime(){
        String[] temp = LocalTime.now().toString().split(":");
        int local = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]); // converts HH:MM form to MM
        return local;
    }

    public Date getCurrentDate(){
        Date date = new Date();
        return date;
    }

	public String getEmployeeType() {
		return this.employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
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