import java.util.*;
import java.time.*;

public class SystemManager {

	private ArrayList<Employee> employeeList;
	private Scheduler schedulerInstance;
	private ArrayList<Requests> requestList;
	private ArrayList<Requests> approvedRequestList;
	private DataManager dataManager;
	private Week currentSchedule;
	private static SystemManager instance;


	private SystemManager() {
        dataManager = new DataManager();
        schedulerInstance = new Scheduler();
        requestList = new ArrayList<>();
        approvedRequestList = new ArrayList<>();
        employeeList = new ArrayList<>();
        currentSchedule = new Week();
	}

	public void initializer(){

	    currentSchedule = SystemManager.getInstance().getDataManager().getSchedule(SystemManager.getInstance().getFirstDayOfWeek());
		requestList = SystemManager.getInstance().getDataManager().getRequestsList("requests");
		approvedRequestList = SystemManager.getInstance().getDataManager().getRequestsList("approvedRequests");
		ArrayList<String> employeeFileNames = SystemManager.getInstance().getDataManager().getEmployeeList();
		for(int i = 0 ; i < employeeFileNames.size() ; i++) {
			employeeList.add(SystemManager.getInstance().getDataManager().getEmployee(employeeFileNames.get(i)));
		}
		SystemManager.getInstance().schedulerInstance.setScheduleRules(SystemManager.getInstance().getDataManager().getSchedule("schedulerRules"));
	}

	public Boolean login(String userName, String Password) {
		if(findEmployee(userName).getUserPassword().equals(Password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getFirstDayOfWeek(){
	    return "010101";
    }

	public int getTime(){
        String[] temp = LocalTime.now().toString().split(":");
        int local = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        return local;
    }

	public void addRequest(Requests r){
	    this.requestList.add(r);
    }

	public Employee findEmployee(String userName) {
		for(int i = 0 ; i < this.employeeList.size() ; i++) {
			if (this.employeeList.get(i).getUserName().equals(userName))
			{
				return this.employeeList.get(i);
			}
		}
		return null;
	}

	public static SystemManager getInstance(){
		if(instance == null){
			instance = new SystemManager();
		}
		return instance;
	}

	public void removeEmployee(String userName){
		ArrayList<Employee> a = this.getEmployeeList();
		for(int i = 0 ; i < a.size() ; i++){
			if(a.get(i).getUserName().equals(userName)){
				this.employeeList.remove(i);
			}
		}
	}

	public void removeRequest(Requests a){
		for(int i = 0 ; i < this.requestList.size() ; i++){
			if(this.requestList.get(i).equals(a)){
				this.requestList.remove(i);
				return;
			}
		}
	}

	public void addApprovedRequest(Requests a){
		this.approvedRequestList.add(a);
	}

	public void addEmployee(Employee employee){
		this.employeeList.add(employee);
	}


	public ArrayList<Employee> getEmployeeList() {
		return this.employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Scheduler getScheduler() {
		return this.schedulerInstance;
	}

	public void setScheduler(Scheduler scheduler) {
		this.schedulerInstance = scheduler;
	}

	public ArrayList<Requests> getRequestList() {
		return this.requestList;
	}

	public void setApprovedRequestList(ArrayList<Requests> requestList) {
		this.approvedRequestList = requestList;
	}

	public ArrayList<Requests> getApprovedRequestList() {
		return this.approvedRequestList;
	}

	public void setRequestList(ArrayList<Requests> requestList) {
		this.requestList = requestList;
	}

	public DataManager getDataManager() {
		return this.dataManager;
	}

	public void setDataManager(DataManager dataManager) {
		this.dataManager = dataManager;
	}

	public Week getCurrentSchedule() {
		return this.currentSchedule;
	}

	public void setCurrentSchedule(Week currentSchedule) {
		this.currentSchedule = currentSchedule;
	}

}


