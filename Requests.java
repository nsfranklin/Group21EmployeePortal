public class Requests {

	SystemManager requestManager;
	private int dateMade;
	private int timeMade;
	private int requestID;

	public Requests(int dateMade, int timeMade, int requestID ){ //DDMMYY, totalMinutesToTime, 7digitInt (10 million should be enough)
        this.dateMade = dateMade;
        this.dateMade = timeMade;
        this.requestID = requestID; //this constructor is for data import.
	}

    public Requests(int dateMade, int timeMade) {
        this.dateMade = dateMade;
        this.dateMade = timeMade;
        this.requestID = //find last request number.
    }

}
