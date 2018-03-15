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
		ArrayList<Employee> timetabledEmployees = ActiveUsers;
	    Week tempWeek = addFullTimeEmployees(activeUsers);

	}

	public Week addFullTimeEmployees(ArrayList<Employee> a) {
		for(int i = 0 ; i < a.size() ; i++){
			if(!(a.get(i) instanceof  PartTimeEmployee)){
				for(int j = 0 ; j < 7 ; j++){
					
				}
			}
		}
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
