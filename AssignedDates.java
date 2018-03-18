import java.util.ArrayList;

public class AssignedDates extends Date {

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

	public ArrayList<String> getUserAssigned(){
		return this.userAssigned;
	}
}