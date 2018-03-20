import java.util.*;

public class Scheduler {

	private Week scheduleRules;
	private Week unapprovedSchedule;

	public Scheduler() {
		this.scheduleRules = new Week();
		this.unapprovedSchedule = new Week();
	}

	public Week createProvisionalSchedule(ArrayList<Requests> approvedRequests, ArrayList<Employee> activeUsers, Date date) {
		ArrayList<Employee> timetabledEmployees = activeUsers;
	    Week tempWeek = addFullTimeEmployees(approvedRequests, activeUsers, date);
		tempWeek = addPartTimeEmployeesFirstPass(approvedRequests,activeUsers,tempWeek,scheduleRules,date);

	    return tempWeek;
	}

	public Week addPartTimeEmployeesFirstPass(ArrayList<Requests> approvedRequests, ArrayList<Employee> a, Week wipSchedule, Week scheduleRules,Date date){
		Week temp = new Week();
		for(int i = 0 ; i < a.size() ; i++){
			if(!(a.get(i) instanceof  PartTimeEmployee)){
				for(int j = 0 ; j < 7 ; j++){
					//if(requestCheck(approvedRequests, a.get(i).getUserName(), date) && availibilityOverlap(scheduleRules, ) >= 3) {
					//	temp.getDate(i).addTimes(a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[0], a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[1]);
					//}
				} //this adds the availability of the employee directly to a Week. As full time employees are expected to work all there hours.
			}
		}
		return temp;
	}

	public Week addPartTimeEmployeesSecondPass(ArrayList<Requests> approvedRequests, ArrayList<Employee> a, Week wipSchedule, Week scheduleRules,Date date){
		Week temp = wipSchedule;
		return temp;
	}

	public Week addPartTimeEmployeesThirdPass(ArrayList<Requests> approvedRequests, ArrayList<Employee> a, Week wipSchedule, Week scheduleRules,Date date){
		Week temp = wipSchedule;
		return temp;
	}


	public Week addFullTimeEmployees(ArrayList<Requests> approvedRequests, ArrayList<Employee> a,Date date) {
		Week temp = new Week();
		for(int i = 0 ; i < a.size() ; i++){
			if(!(a.get(i) instanceof  PartTimeEmployee)){
				for(int j = 0 ; j < 7 ; j++){
					if(requestCheck(approvedRequests, a.get(i).getUserName(), date)) {
						temp.getDate(i).addTimes(a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[0], a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[1]);
					}
				} //this adds the availability of the employee directly to a Week. As full time employees are expected to work all there hours.
			}
		}
		return temp;
	}

	public Boolean requestCheck(ArrayList<Requests> approvedRequests, String userName, Date date){ //checks if a employee has sceduled timeOff
		for(int i = 0 ; i < approvedRequests.size() ; i++){
			if(!(approvedRequests.get(i) instanceof systemRequest)){
				timeOff temp = (timeOff) approvedRequests.get(i);
				if(temp.equals(userName)){
					if( (date.equals(temp.getStartDate())) || (date.after(temp.getStartDate()) && date.before(temp.getEndDate())) || (date.equals(temp.getEndDate()))){
						return false;
					}
				}
			}
		}
		return true;
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
}
