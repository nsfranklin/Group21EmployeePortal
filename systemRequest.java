import java.util.Date;

public class systemRequest extends Requests {

	private Date deadline;

	public systemRequest(Date dateMade, int timeMade, Date deadline){
		super(dateMade,timeMade);
		this.deadline = deadline;
	}
}