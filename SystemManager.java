import java.util.*;

public class SystemManager {

	Collection<Employee> employees;
	Scheduler scheduler;
	Collection<Requests> request;
	DataManager dateManager;
	SystemManagerController smcontroller;
	private ArrayList<Employee> employeeList;
	private Scheduler schedulerInstance;
	private ArrayList<Requests> requestList;
	private DataManager dataManager;
	private Week currentSchedule;
	private static SystemManager instance;

	private SystemManager() {
		// TODO - implement SystemManager.SystemManager
		throw new UnsupportedOperationException();
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

	public Employee findEmployee(String userName) {
		for(int i = 0 ; i < this.employeeList.size() ; i++) {
			if (this.employeeList.get(i).getUserName().equals(userName))
			{
				return this.employeList.get(i);
			}
		}
	}

	public static SystemManager getInstance() {
		if(instance == null){
			instance = new SystemManager();
		}
		return instance;
	}

	public ArrayList<Employee> getEmployeeList() {
		return this.employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Scheduler getScheduler() {
		return this.scheduler;
	}

	/**
	 * 
	 * @param scheduler
	 */
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public ArrayList<Requests> getRequestList() {
		return this.requestList;
	}

	/**
	 * 
	 * @param requestList
	 */
	public void setRequestList(ArrayList<Requests> requestList) {
		this.requestList = requestList;
	}

	public DataManager getDataManager() {
		return this.dataManager;
	}

	/**
	 * 
	 * @param dataManager
	 */
	public void setDataManager(DataManager dataManager) {
		this.dataManager = dataManager;
	}

	public Week getCurrentSchedule() {
		return this.currentSchedule;
	}

	/**
	 * 
	 * @param currentSchedule
	 */
	public void setCurrentSchedule(Week currentSchedule) {
		this.currentSchedule = currentSchedule;
	}

}
