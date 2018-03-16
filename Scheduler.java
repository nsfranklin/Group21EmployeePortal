import java.util.*;

public class Scheduler {

	private Week scheduleRules;
	private Week unapprovedSchedule;
	private static Scheduler instance;

	private Scheduler() {
		this.scheduleRules = null;
		this.unapprovedSchedule = null;
	}

	public Week createProvisionalSchedule(ArrayList<Requests> approvedRequests, Week scheduleRules, ArrayList<Employee> activeUsers) {
		ArrayList<Employee> timetabledEmployees = activeUsers;
	    Week tempWeek = addFullTimeEmployees(activeUsers);
		tempWeek = addPartTimeEmployees(activeUsers,tempWeek,scheduleRules);

	    return tempWeek;
	}

	public Week addPartTimeEmployees(ArrayList<Requests> approvedRequests, ArrayList<Employee> a, Week temp, Week scheduleRules){
		temp = new Week();
		for(int i = 0 ; i < a.size() ; i++){
			if(!(a.get(i) instanceof  PartTimeEmployee)){
				for(int j = 0 ; j < 7 ; j++){
					if() {
						temp.getDate(i).addTimes(a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[0], a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[1]);
					}
				} //this adds the availability of the employee directly to a Week. As full time employees are expected to work all there hours.
			}
		}
		return temp;
	}

	public Week addFullTimeEmployees(ArrayList<Requests> approvedRequests, ArrayList<Employee> a) {
		Week temp = new Week();
		for(int i = 0 ; i < a.size() ; i++){
			if(!(a.get(i) instanceof  PartTimeEmployee)){
				for(int j = 0 ; j < 7 ; j++){
					if() {
						temp.getDate(i).addTimes(a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[0], a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[1]);
					}
				} //this adds the availability of the employee directly to a Week. As full time employees are expected to work all there hours.
			}
		}
		return temp;
	}

	public Boolean requestCheck(ArrayList<Requests> approvedRequests, String userName){ //checks if a employee has sceduled timeOff

	}

	public Week getScheduleRules() {
		return this.getScheduleRules();
	}

	public void setScheduleRules(Week scheduleRules) {
		this.scheduleRules = scheduleRules;
	}

	public Boolean checkSchedule(Week managersAlteredSchedule) {
		// TODO - implement Scheduler.checkSchedule
		throw new UnsupportedOperationException();
	}

	public Boolean approveSchedule(Week finalSchedule) {
		// TODO - implement Scheduler.approveSchedule
		throw new UnsupportedOperationException();
	}

	public void createSystemRequest(int deadline) {
		// TODO - implement Scheduler.createSystemRequest
		throw new UnsupportedOperationException();
	}

	public static Scheduler getInstance() {
		if(instance == null) {
			instance = new Scheduler();
		}
		return instance;
	}

}
