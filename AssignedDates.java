import java.util.ArrayList;

public class AssignedDates extends DateImp {

	private ArrayList<String> userAssigned;

	public AssignedDates(int[] startTime, int[] length, String[] userNames) {
		super(startTime,length);
		userAssigned = new ArrayList<>();
		for(int i = 0 ; i < userNames.length ; i++) {
			userAssigned.add(userNames[i]);
		}
	}

	public AssignedDates(String[] startTime, String[] length, String[] userNames) {
		super(startTime,length);
		userAssigned = new ArrayList<>();
		for(int i = 0 ; i < userNames.length ; i++) {
			userAssigned.add(userNames[i]);
		}
	}

	public void addUserTimes(int startTime, int length, String userName ) {  //length is in minutes 60 is 1 hour. Has to be multiple of 30
		super.addTimes(startTime,length);
		this.userAssigned.add(userName);
	}

	public ArrayList<String> getUserAssigned(){
		return this.userAssigned;
	}
}