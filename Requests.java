import java.util.Date;

public class Requests {

	SystemManager requestManager;
	private Date dateMade;
    private int timeMade;

    public Requests(Date dateMade, int timeMade) {
        this.dateMade = dateMade;
        this.timeMade = timeMade;
    }

    public Date getDateMade() {
        return this.dateMade;
    }
}
