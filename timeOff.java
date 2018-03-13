public class timeOff extends Requests {

	private String timeOffType;
	private int startDate;
	private int endDate;
	private String description;
	private String userName;

	public timeOff(int dateMade, int timeMade, int requestID, String timeOffType, int startDate, int endDate, String description, String userName) {
        super(dateMade,timeMade,requestID);
        this.timeOffType = timeOffType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.userName = userName;
    }
}