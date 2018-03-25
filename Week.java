import java.util.Arrays;


public class Week {

	private DateImp[] days; //array because week are 7 days always

	public Week()
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

    public Week(String startMon, String lengthMon, String startTue, String lengthTue, String startWed, String lengthWed, String startThu, String lengthThu, String startFri, String lengthFri, String startSat, String lengthSat, String startSun, String lengthSun){
        days = new DateImp[7];
        for(int i = 0 ; i < 7 ; i++)
            days[i] = new DateImp();
        this.days[0] = new DateImp (Integer.parseInt(startMon)*60, Integer.parseInt(lengthMon)*60);
        this.days[1] = new DateImp (Integer.parseInt(startTue)*60, Integer.parseInt(lengthTue)*60);
        this.days[2] = new DateImp (Integer.parseInt(startWed)*60, Integer.parseInt(lengthWed)*60);
        this.days[3] = new DateImp (Integer.parseInt(startThu)*60, Integer.parseInt(lengthThu)*60);
        this.days[4] = new DateImp (Integer.parseInt(startFri)*60, Integer.parseInt(lengthFri)*60);
        this.days[5] = new DateImp (Integer.parseInt(startSat)*60, Integer.parseInt(lengthSat)*60);
        this.days[6] = new DateImp (Integer.parseInt(startSun)*60, Integer.parseInt(lengthSun)*60);
    } //the add new structor time are given in hours at first

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