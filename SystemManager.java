import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import java.util.Calendar;

public class SystemManager {

	private ArrayList<Employee> employeeList;
	private Scheduler schedulerInstance;
	private ArrayList<Requests> requestList;
	private ArrayList<Requests> approvedRequestList;
	private DataManager dataManager;
	private Week currentSchedule;
	private static SystemManager instance;
	private ArrayList<ClockedHours> clockedHoursList;
	private ArrayList<Week> futureSchedules;


	private SystemManager() {
        dataManager = new DataManager();
        schedulerInstance = new Scheduler();
        requestList = new ArrayList<>();
        approvedRequestList = new ArrayList<>();
        employeeList = new ArrayList<>();
        currentSchedule = new Week();
        clockedHoursList = new ArrayList<>();
        futureSchedules = new ArrayList<>();
	}

	public void initializer() {
	    currentSchedule = SystemManager.getInstance().getDataManager().getScheduleWithAssignedUsers(SystemManager.getInstance().getFirstDayOfWeek());
		requestList = SystemManager.getInstance().getDataManager().getRequestsList("requests");
		approvedRequestList = SystemManager.getInstance().getDataManager().getRequestsList("approvedRequests");
		ArrayList<String> employeeFileNames = SystemManager.getInstance().getDataManager().getEmployeeList();
		for(int i = 0 ; i < employeeFileNames.size() ; i++) {
			employeeList.add(SystemManager.getInstance().getDataManager().getEmployee(employeeFileNames.get(i)));
		}
		SystemManager.getInstance().schedulerInstance.setScheduleRules(SystemManager.getInstance().getDataManager().getSchedule("scheduleRules"));
		SystemManager.getInstance().schedulerInstance.setUnapprovedSchedule(SystemManager.getInstance().getDataManager().getScheduleWithAssignedUsers("provisional"));

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
		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
		int date = c.get(c.DAY_OF_WEEK);
		if(date == 1){
			c.add(c.DATE , -6);
		}
		else{
			c.add(c.DAY_OF_MONTH, -(date -2 ));
		}
	    return format.format(c.getTime());
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

	public void addClockedHours(ClockedHours c){
		this.clockedHoursList.add(c);
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

	public ArrayList<String> getUsernameList(){
		ArrayList<String> a = new ArrayList<>();
		for(int i = 0 ; i < this.getEmployeeList().size() ; i++){
			a.add(this.getEmployeeList().get(i).getUserName());
		}
		return a;
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

	public ArrayList<ClockedHours> getClockedHoursList(){
		return this.clockedHoursList;
	}

	public void setClockedHoursList(ArrayList<ClockedHours> a){
		this.clockedHoursList = a;
	}

	public ArrayList<Week> getFutureSchedules() {
		return this.futureSchedules;
	}

	public void setFutureSchedules(ArrayList<Week> futureSchedules) {
		this.futureSchedules = futureSchedules;
	}


}


