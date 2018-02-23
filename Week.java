public class Week {

	Scheduler rulesmanager;
	Employee employee;
	Date date;
	private Date[] days;

	public Week() // when a week is first called it is populated with empty Date
    {
	    days = new Date[7];
        for(int i = 0 : i < 7 : i++)
        {
            days[i] = new Date();
        }
	}

	public void addDay(int dayOfWeekIndex, Date d)
    {
		this.days[i] = d;
    }
}