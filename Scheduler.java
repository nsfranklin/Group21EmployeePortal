import java.util.*;

public class Scheduler {

	SystemManager reqManager;
	Collection<Week> scheduleRule;
	private Week scheduleRules;
	private Week unapprovedSchedule;
	private Scheduler instance;

	/**
	 * 
	 * @param prov
	 * @param b
	 */
	public Week createProvisionalSchedule(Date[][] prov, ScheduleRules b) {
		// TODO - implement Scheduler.createProvisionalSchedule
		throw new UnsupportedOperationException();
	}

	public Week getSetScheduleRules() {
		// TODO - implement Scheduler.getSetScheduleRules
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param scheduleRules
	 */
	public void setScheduleRules(Week scheduleRules) {
		this.scheduleRules = scheduleRules;
	}

	/**
	 * 
	 * @param managersAlteredSchedule
	 */
	public Boolean checkSchedule(Week managersAlteredSchedule) {
		// TODO - implement Scheduler.checkSchedule
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param finalSchedule
	 */
	public Boolean approveSchedule(Week finalSchedule) {
		// TODO - implement Scheduler.approveSchedule
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param deadline
	 */
	public void createSystemRequest(Time deadline) {
		// TODO - implement Scheduler.createSystemRequest
		throw new UnsupportedOperationException();
	}

	public Scheduler() {
		// TODO - implement Scheduler.Scheduler
		throw new UnsupportedOperationException();
	}

	public Scheduler getInstance() {
		return this.instance;
	}

}