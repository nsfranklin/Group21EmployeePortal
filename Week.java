import java.util.Arrays;


public class Week {

	private DateImp[] days; //array because week are 7 days always

	public Week() // when a week is first called it is populated with empty DateImp
    {
	    days = new DateImp[7];
        for(int i = 0 ; i < 7 ; i++)
        {
            days[i] = new DateImp();
        }
	}

	public Week(int startMon, int lengthMon, int startTue, int lengthTue, int startWed, int lengthWed, int startThu, int lengthThu, int startFri, int lengthFri, int startSat, int lengthSat, int startSun, int lengthSun){
        days = new DateImp[7];
        for(int i = 0 ; i < 7 ; i++)
            days[i] = new DateImp();
	    this.days[0] = new DateImp (startMon, lengthMon);
	    this.days[1] = new DateImp (startTue, lengthTue);
	    this.days[2] = new DateImp (startWed, lengthWed);
	    this.days[3] = new DateImp (startThu, lengthThu);
	    this.days[4] = new DateImp (startFri, lengthFri);
	    this.days[5] = new DateImp (startSat, lengthSat);
	    this.days[6] = new DateImp (startSun, lengthSun);
    } //contructor if there is only a single time to start each day. eg an employee.

    public Week(int[] startMon, int[] lengthMon, int[] startTue, int[] lengthTue, int[] startWed, int[] lengthWed, int[] startThu, int[] lengthThu, int[] startFri, int[] lengthFri, int[] startSat, int[] lengthSat, int[] startSun, int[] lengthSun) {
        days = new DateImp[7];
        for(int i = 0 ; i < 7 ; i++)
            days[i] = new DateImp();
	    this.days[0] = new DateImp(startMon, lengthMon);
        this.days[1] = new DateImp(startTue, lengthTue);
        this.days[2] = new DateImp(startWed, lengthWed);
        this.days[3] = new DateImp(startThu, lengthThu);
        this.days[4] = new DateImp(startFri, lengthFri);
        this.days[5] = new DateImp(startSat, lengthSat);
        this.days[6] = new DateImp(startSun, lengthSun);
    }

    public Week(String[] startMon, String[] lengthMon, String[] userNameMon,
                String[] startTue, String[] lengthTue, String[] userNameTue,
                String[] startWed, String[] lengthWed, String[] userNameWed,
                String[] startThu, String[] lengthThu, String[] userNameThu,
                String[] startFri, String[] lengthFri, String[] userNameFri,
                String[] startSat, String[] lengthSat, String[] userNameSat,
                String[] startSun, String[] lengthSun, String[] userNameSun) {

        days = new DateImp[7];
        for(int i = 0 ; i < 7 ; i++)
            days[i] = new DateImp();
        this.days[0] = new AssignedDates(startMon, lengthMon, userNameMon);
        this.days[1] = new AssignedDates(startTue, lengthTue, userNameTue);
        this.days[2] = new AssignedDates(startWed, lengthWed, userNameWed);
        this.days[3] = new AssignedDates(startThu, lengthThu, userNameThu);
        this.days[4] = new AssignedDates(startFri, lengthFri, userNameFri);
        this.days[5] = new AssignedDates(startSat, lengthSat, userNameSat);
        this.days[6] = new AssignedDates(startSun, lengthSun, userNameSun);
    }


    public void addDay(int dayOfWeekIndex, DateImp d)
    {
		this.days[dayOfWeekIndex] = d;
    }

    public DateImp getDate(int dayIndex){
        return this.days[dayIndex];
    }

}