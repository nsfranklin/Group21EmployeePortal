import java.time.Clock;
import java.util.ArrayList;

public class SystemManagerController {

	private SystemManager model;
	private View view;

	public SystemManagerController(SystemManager sM, View view){
		this.model = sM;
		this.view = view;
	}

	public void update() {
		view.updateDetails(this.getEmployeeList(), this.getRequestList(),
				this.getApprovedRequestList(), this.getCurrentSchedule(),
				this.getClockedHoursList(), this.getFutureSchedules(), new ArrayList<FinalHoursWorked>(), this.getScheduler());
	}

	public ArrayList<Employee> getEmployeeList() {
		return model.getEmployeeList();
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		model.setEmployeeList(employeeList);
	}

	public ArrayList<Requests> getRequestList() {
		return model.getRequestList();
	}

	public void setRequestList(ArrayList<Requests> requestList) {
		model.setRequestList(requestList);
	}

	public ArrayList<Requests> getApprovedRequestList() {
		return model.getApprovedRequestList();
	}

	public void setAppovedRequestList(ArrayList<Requests> requestList) {
		model.setApprovedRequestList(requestList);
	}

	public Week getCurrentSchedule() {
		return model.getCurrentSchedule();
	}

	public void setCurrentSchedule(Week currentSchedule) {
		model.setCurrentSchedule(currentSchedule);
	}

	public ArrayList<ClockedHours> getClockedHoursList(){
		return model.getClockedHoursList();
	}

	public void setClockedHoursList(ArrayList<ClockedHours> a) {model.setClockedHoursList(a);}

	public Employee findEmployee(String username){
		return model.findEmployee(username);
	}

	public void removeEmployee(String userName){
		model.removeEmployee(userName);
	}

	public void setScheduler(Scheduler s){
		model.setScheduler(s);
	}

	public Scheduler getScheduler(){
		return model.getScheduler();
	}

	public ArrayList<Week> getFutureSchedules(){return model.getFutureSchedules();}

	public void setFutureSchedules(ArrayList<Week> schedulesToAdd){ model.setFutureSchedules(schedulesToAdd);}

}