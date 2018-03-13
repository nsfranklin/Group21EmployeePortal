import java.util.ArrayList;

public class AssignedDates extends Date {

	private ArrayList<String> userAssigned;

	public AssignedDates(int[] startTime, int[] length, String[] userNames) {
		super(startTime,length);
		for(int i = 0 ; i < userNames.length ; i++) {
			userAssigned.add(userNames[i]);
		}
	}
}