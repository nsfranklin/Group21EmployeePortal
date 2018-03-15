import java.util.*;
import java.time.*;

public class SystemManager {

	private ArrayList<Employee> employeeList;
	private Scheduler schedulerInstance;
	private ArrayList<Requests> requestList;
	private DataManager dataManager;
	private Week currentSchedule;
	private static SystemManager instance;

	private SystemManager() {
        dataManager = new DataManager();
        schedulerInstance = Scheduler.getInstance();
        currentSchedule = dataManager.getSchedule(this.getTime());
        requestList = dataManager.getRequestsList();
        ArrayList<String> employeeFileNames = dataManager.getEmployeeList();
        for(int i = 0 ; i < employeeFileNames.size() ; i++) {
            employeeList.add(dataManager.getEmployee(employeeFileNames.get(i)));
        }
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

	public static void initialiseEmployeeList(){
		SystemManager.getInstance();
		ArrayList<String> employeeList = SystemManager.getInstance().dataManager.getEmployeeList();
		ArrayList<Employee> temp = new ArrayList<>();
		for(int i = 0 ; i < employeeList.size() ; i++) {
			temp.add(SystemManager.getInstance().dataManager.getEmployee(employeeList.get(i)));
		}
		SystemManager.getInstance().setEmployeeList(temp);
	}

	public static void initialiseRequestList(){
		SystemManager.getInstance().setRequestList(SystemManager.getInstance().dataManager.getRequestsList());
	}

	public static void main(String[] arg){
		initialiseEmployeeList();
		initialiseRequestList();

    }
}


