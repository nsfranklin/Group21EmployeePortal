import java.util.*;

public class Scheduler {

	SystemManager reqManager;
	Collection<Week> scheduleRule;
	private Week scheduleRules;
	private Week unapprovedSchedule;
	private static Scheduler instance;

	public Scheduler() {
		// TODO - implement Scheduler.Scheduler
		throw new UnsupportedOperationException();
	}

	public Week createProvisionalSchedule(Date[][] prov, Week scheduleRules, ArrayList<Employee> activeUsers) {
		ArrayList<Employee> timetabledEmployees = activeUsers;
	    Week tempWeek = addFullTimeEmployees(activeUsers);


	    return tempWeek;
	}

	public Week addPartTimeEmployees(ArrayList<Employee> a, Week temp){


	    return temp;
	}

	public Week addFullTimeEmployees(ArrayList<Employee> a) {
		Week temp = new Week();
		for(int i = 0 ; i < a.size() ; i++){
			if(!(a.get(i) instanceof  PartTimeEmployee)){
				for(int j = 0 ; j < 7 ; j++){
					temp.getDate(i).addTimes(a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[0] , a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[1]);
				} //this adds the availability of the employee directly to a Week. As full time employees are expected to work all there hours.
			}
		}
		return temp;
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
