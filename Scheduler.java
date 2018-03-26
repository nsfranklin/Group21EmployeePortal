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
		Week temp = wipSchedule;
		for(int i = 0 ; i < a.size() ; i++){
			if(!(a.get(i) instanceof  PartTimeEmployee)){
				for(int j = 0 ; j < 7 ; j++){
					if((requestCheck(approvedRequests, a.get(i).getUserName(), date))){
						int index = unassignedIndex(temp, scheduleRules); //returns -1 if no index are completely empty
						if(index > -1) {
							if(availabilityOverlapFirstPass(scheduleRules, a.get(i), i, index)) {
								int startOffset = startTimeOffset(scheduleRules, a.get(i), i, index);
								int length = lengthAvailable(scheduleRules, a.get(i), i, index);
								temp.getDate(i).addTimes(a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[0], a.get(i).getEmployeeAvalibility().getDate(j).getTimes().get(0)[1]);
							}
						}
					}
				} //this adds the availability of the employee directly to a Week. As full time employees are expected to work all there hours.
			}
		}
		return temp;
	}

	public Week addPartTimeEmployeesSecondPass(ArrayList<Requests> approvedRequests, ArrayList<Employee> a, Week wipSchedule, Week scheduleRules,Date date){ // as to cover small gaps in schedule
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

	public int unassignedIndex(Week wipSchedule, Week scheduleRules){

		return -1;
	}

	public int lengthAvailable(Week rules, Employee e, int DayOfWeek, int arrayListIndex){

		return 0;
	}

	public int startTimeOffset(Week rules, Employee e, int DayOfWeek, int arrayListIndex){

		return 0;
	}

	public Boolean availabilityOverlapFirstPass(Week rules, Employee e, int DayOfWeek, int arrayListIndex){

		return true;
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
		return this.scheduleRules;
	}

	public void setScheduleRules(Week scheduleRules) {
		this.scheduleRules = scheduleRules;
	}

	public Week getUnapprovedSchedule() {
		return this.unapprovedSchedule;
	}

	public void setUnapprovedSchedule(Week unapprovedSchedule){
		this.unapprovedSchedule = unapprovedSchedule;
	}

	public Boolean checkSchedule(Week managersAlteredSchedule) {
		// TODO - implement Scheduler.checkSchedule
		throw new UnsupportedOperationException();
	}

	public Boolean approvable(){
		Week rules = this.scheduleRules;
		Week target = this.unapprovedSchedule;
		int rulesTotalTime = 0;
		int targetTotalTime = 0;

		for(int i = 0 ; i < 7 ; i++){
			if(rules.getDate(i).getTimes().size() > target.getDate(i).getTimes().size()){
				return false;
			}
			for(int j = 0 ; (j < rules.getDate(i).getTimes().size()) && (j < target.getDate(i).getTimes().size()) ; j++ ) {
				if (rules.getDate(i).getTimes().get(j) != null) {
					rulesTotalTime = rulesTotalTime + rules.getDate(i).getTimes().get(j)[1];
				}
				if (target.getDate(i).getTimes().get(j) != null){
					targetTotalTime = targetTotalTime + target.getDate(i).getTimes().get(j)[1];
				}
			}
			if(rulesTotalTime > targetTotalTime){
				return false;
			}
			rulesTotalTime = 0;
			targetTotalTime = 0;
		}
		return true;
	}

	public void approveSchedule() {
		View.getInstance().getSMC().getFutureSchedules().add(View.getInstance().getScheduler().getUnapprovedSchedule());
		View.getInstance().getSMC().getScheduler().setUnapprovedSchedule(null);
		View.getInstance().getSMC().update();
	}

	public void createSystemRequest(int deadline) {
		// TODO - implement Scheduler.createSystemRequest
		throw new UnsupportedOperationException();
	}
}
