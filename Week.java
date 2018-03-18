import java.util.Arrays;


public class Week {

	private Date[] days; //array because week are 7 days always

	public Week() // when a week is first called it is populated with empty Date
    {
	    days = new Date[7];
        for(int i = 0 ; i < 7 ; i++)
        {
            days[i] = new Date();
        }
	}

	public Week(int startMon, int lengthMon, int startTue, int lengthTue, int startWed, int lengthWed, int startThu, int lengthThu, int startFri, int lengthFri, int startSat, int lengthSat, int startSun, int lengthSun){
        days = new Date[7];
        for(int i = 0 ; i < 7 ; i++)
            days[i] = new Date();
	    this.days[0] = new Date (startMon, lengthMon);
	    this.days[1] = new Date (startTue, lengthTue);
	    this.days[2] = new Date (startWed, lengthWed);
	    this.days[3] = new Date (startThu, lengthThu);
	    this.days[4] = new Date (startFri, lengthFri);
	    this.days[5] = new Date (startSat, lengthSat);
	    this.days[6] = new Date (startSun, lengthSun);
    } //contructor if there is only a single time to start each day. eg an employee.

    public Week(int[] startMon, int[] lengthMon, int[] startTue, int[] lengthTue, int[] startWed, int[] lengthWed, int[] startThu, int[] lengthThu, int[] startFri, int[] lengthFri, int[] startSat, int[] lengthSat, int[] startSun, int[] lengthSun) {
        days = new Date[7];
        for(int i = 0 ; i < 7 ; i++)
            days[i] = new Date();
	    this.days[0] = new Date(startMon, lengthMon);
        this.days[1] = new Date(startTue, lengthTue);
        this.days[2] = new Date(startWed, lengthWed);
        this.days[3] = new Date(startThu, lengthThu);
        this.days[4] = new Date(startFri, lengthFri);
        this.days[5] = new Date(startSat, lengthSat);
        this.days[6] = new Date(startSun, lengthSun);
    }

    public Week(String[] startMon, String[] lengthMon, String[] userNameMon,
                String[] startTue, String[] lengthTue, String[] userNameTue,
                String[] startWed, String[] lengthWed, String[] userNameWed,
                String[] startThu, String[] lengthThu, String[] userNameThu,
                String[] startFri, String[] lengthFri, String[] userNameFri,
                String[] startSat, String[] lengthSat, String[] userNameSat,
                String[] startSun, String[] lengthSun, String[] userNameSun) {

        days = new Date[7];
        for(int i = 0 ; i < 7 ; i++)
            days[i] = new Date();
        this.days[0] = new AssignedDates(startMon, lengthMon, userNameMon);
        this.days[1] = new AssignedDates(startTue, lengthTue, userNameTue);
        this.days[2] = new AssignedDates(startWed, lengthWed, userNameWed);
        this.days[3] = new AssignedDates(startThu, lengthThu, userNameThu);
        this.days[4] = new AssignedDates(startFri, lengthFri, userNameFri);
        this.days[5] = new AssignedDates(startSat, lengthSat, userNameSat);
        this.days[6] = new AssignedDates(startSun, lengthSun, userNameSun);
    }


    public void addDay(int dayOfWeekIndex, Date d)
    {
		this.days[dayOfWeekIndex] = d;
    }

    public Date getDate(int dayIndex){
        return this.days[dayIndex];
    }

}