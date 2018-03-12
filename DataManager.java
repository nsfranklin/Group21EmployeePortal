import java.io.*;

public class DataManager {


	DataManager(){}

	public Employee getEmployee(String employeeID) throws IOException{

	    String data = fetchData(employeeID + ".txt");
	    String[] splitData = data.split(",");
	    PayrollDetails payroll = new PayrollDetails(Integer.parseInt(split[2]),Integer.parseInt(splitData[3]));
	    Week availability = new Week(Integer.parseInt(splitData[6]),Integer.parseInt(splitData[7]),Integer.parseInt(splitData[8]),Integer.parseInt(splitData[9]),Integer.parseInt(splitData[10]),Integer.parseInt(splitData[11]),Integer.parseInt(splitData[12]),Integer.parseInt(splitData[13]),Integer.parseInt(splitData[14]),Integer.parseInt(splitData[15]),Integer.parseInt(splitData[16]),Integer.parseInt(splitData[17]),Integer.parseInt(splitData[18]),Integer.parseInt(splitData[19]));
        return new Employee(splitData[0],splitData[1],payroll,Boolean.parseBoolean(splitData[4]),availability);
	}

	public Boolean addSchedule(Week s) {
		// TODO - implement DataManager.addSchedule
		throw new UnsupportedOperationException();
	}

	public Week getSchedule(int date)  throws IOException {//Date format DDMMYY // , split starts and length and ,, split days
		String data = fetchData(date + ".txt");
        String[] splitData = data.split(",,");
        String[][] furtherSplitData = new String[7][];
        for(int i = 0 ; i < 7 ; i++)                //preparing the data for the week constructor
        {
            furtherSplitData[i] = splitData[i].split(",");
        }
        Week temp = new Week(parseScheduleStringArray(furtherSplitData[0],0), parseScheduleStringArray(furtherSplitData[0], 1),
                parseScheduleStringArray(furtherSplitData[1],0), parseScheduleStringArray(furtherSplitData[1], 1),
                parseScheduleStringArray(furtherSplitData[2],0), parseScheduleStringArray(furtherSplitData[2], 1),
                parseScheduleStringArray(furtherSplitData[3],0), parseScheduleStringArray(furtherSplitData[3], 1),
                parseScheduleStringArray(furtherSplitData[4],0), parseScheduleStringArray(furtherSplitData[4], 1),
                parseScheduleStringArray(furtherSplitData[5],0), parseScheduleStringArray(furtherSplitData[5], 1),
                parseScheduleStringArray(furtherSplitData[6],0), parseScheduleStringArray(furtherSplitData[6], 1));
        return temp;
	} //calling parseScheduleStringArray for every start time and length. (Prototype!)

	private int[] parseScheduleStringArray(String[] a, int i){ //helper method return int[] for week constructor, i indicates start loop.
	    int[] temp = new int[a.length/2];
        for( int j = i ; j < a.length ; j = j + 2)
        {
            temp[i/2] = Integer.parseInt(a[i]);
        }
        return temp;
    }

	public Boolean setEmployeePassword(String name, String password) {
        //redundant in prototype
		throw new UnsupportedOperationException();
	}

	public Boolean addEmployee(String name, String password) {
        //redundant in prototype
		throw new UnsupportedOperationException();
	}

	public Boolean setEmployeeInactive(Employee e) {
        //redundant in prototype
		throw new UnsupportedOperationException();
	}

	public Boolean addClockInTime(Employee e, int clockIn) { //format filename: "Date".txt FileContent username,clockIn,clockOut,,NextEntry
		// TODO - implement DataManager.addClockInTime
		throw new UnsupportedOperationException();
	}

	public Boolean addClockOutTime(Employee e, int clockOut) {
		// TODO - implement DataManager.addClockOutTime
		throw new UnsupportedOperationException();
	}

	public Arraylist<Requests> getRequest() throws IOException{ //dateMade,timeMade,requestID,deadline||timeOffType,startDate||"",endDate||"",description||"",userName,,NEXT ENTRY
		String data = fetchData("request.txt");
		// ON HOLD till request class and sub classes are finished
    }

	public Boolean addRequest(Request r) {
        //redundant in prototype as
		throw new UnsupportedOperationException();
	}

	public Boolean removeRequest(int requestID) {
        //redundant in prototype
	}

	public Boolean setEmployeeAvailability(Employee employee, Week availability) {
        //redundant in prototype
	}

	public void connectToDatabase() {
        //redundant in prototype
	}

	public String fetchData(String filename) throws IOException //file will be written as a single line comma seperated
	{
		try
		{
			BufferedReader inputStream = new BufferedReader(new FileReader(filename));
            String data = inputStream.readLine();
            inputStream.close();
            return data;
		}
		catch (FileNotFoundException e)
		{
			return null; // null returned when no file is present or empty
		}
	}

	public void writeData(String filename, String data) throws IOException
    {
        PrintWriter outputStream = new PrintWriter(new FileWriter(filename));
        outputStream.println(data);
        outputStream.close();
    }
}