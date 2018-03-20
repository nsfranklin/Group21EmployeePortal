import java.util.Date;

public class timeOff extends Requests {

	private String timeOffType;
	private Date startDate;
	private Date endDate;
	private String description;
	private String userName;

	public timeOff(Date dateMade, int timeMade, String timeOffType, Date startDate, Date endDate, String description, String userName) {
        super(dateMade,timeMade);
        this.timeOffType = timeOffType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.userName = userName;
    }

    public String getUserName(){
	    return this.userName;
    }

    public Date getStartDate(){
	    return this.startDate;
    }

    public Date getEndDate(){
	    return this.endDate;
    }

    public String getDescription(){
	    return this.description;
    }

    public String getTimeOffType(){
	    return this.timeOffType;
    }
}