public class systemRequest extends Requests {

	private int deadline;

	public systemRequest(int dateMade, int timeMade, int requestID, int deadline){
		super(dateMade,timeMade,requestID);
		deadline = deadline;
	}
}