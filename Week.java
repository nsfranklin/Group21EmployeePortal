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

	public void addDay(int dayOfWeekIndex, Date d)
    {
		this.days[dayOfWeekIndex] = d;
    }
}