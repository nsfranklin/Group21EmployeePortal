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
	private SystemManager instance;

	private SystemManager() {
		// TODO - implement SystemManager.SystemManager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userName
	 * @param Password
	 */
	public Boolean login(String userName, String Password) {
		// TODO - implement SystemManager.login
		throw new UnsupportedOperationException();
	}

	public SystemManager getInstance() {
		return this.instance;
	}

	public ArrayList<Employee> getEmployeeList() {
		return this.employeeList;
	}

	/**
	 * 
	 * @param employeeList
	 */
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