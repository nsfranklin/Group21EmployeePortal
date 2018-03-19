import java.time.Clock;
import java.util.ArrayList;

public class SystemManagerController {

	private SystemManager model;
	private Homepage view;

	public SystemManagerController(SystemManager sM, Homepage view){
		this.model = sM;
		this.view = view;
	}

	public void update() {
		//view.updateDetails(getEmployeeList(), getRequestList(), getApprovedRequestList(), getCurrentSchedule(), getClockedHoursList(), new ArrayList<Week> );
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
}