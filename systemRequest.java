public class systemRequest extends Requests {

	private int deadline;

	public systemRequest(int dateMade, int timeMade, int deadline){
		super(dateMade,timeMade);
		deadline = deadline;
	}
}