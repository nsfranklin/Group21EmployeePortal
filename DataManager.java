import java.io.*;
import java.util.ArrayList;

public class DataManager {


	DataManager(){}

	public Employee getEmployee(String employeeID) {
	    String data = fetchData(employeeID + ".txt");
	    String[] splitData = data.split(",");
	    PayrollDetails payroll = new PayrollDetails(Integer.parseInt(splitData[2]),Integer.parseInt(splitData[3]));
	    Week availability = new Week(Integer.parseInt(splitData[5]),Integer.parseInt(splitData[6]),Integer.parseInt(splitData[7]),Integer.parseInt(splitData[8]),Integer.parseInt(splitData[9]),Integer.parseInt(splitData[10]),Integer.parseInt(splitData[11]),Integer.parseInt(splitData[12]),Integer.parseInt(splitData[13]),Integer.parseInt(splitData[14]),Integer.parseInt(splitData[15]),Integer.parseInt(splitData[16]),Integer.parseInt(splitData[17]),Integer.parseInt(splitData[18]));
        if(splitData[19].equals("employee")) {
			return new Employee(splitData[0], splitData[1], payroll, Boolean.parseBoolean(splitData[4]), availability);
		}else if(splitData[19].equals("parttimeemployee")){
			return new PartTimeEmployee(splitData[0], splitData[1], payroll, Boolean.parseBoolean(splitData[4]), availability);
		}else if(splitData[19].equals("manager")){
			return new Manager(splitData[0], splitData[1], payroll, Boolean.parseBoolean(splitData[4]), availability);
		}else if(splitData[19].equals("admin")){
			return new Admin(splitData[0], splitData[1], payroll, Boolean.parseBoolean(splitData[4]), availability);
		}
		return null;
	}

	public Boolean addSchedule(Week s) {
		// TODO - implement DataManager.addSchedule
		throw new UnsupportedOperationException();
	}

	public Week getSchedule(int date) {//Date format DDMMYY // , split starts and length and ,, split days
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

	public Week getScheduleWithAssignedUsers(int date){
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
	}

	private int[] parseScheduleStringArray(String[] a, int i){ //helper method return int[] for week constructor, i indicates start loop.
	    int[] temp = new int[a.length/2];
        for( int j = i ; j < a.length ; j = j + 2)
        {
            temp[i/2] = Integer.parseInt(a[i]);
        }
        return temp;
    }

    public ArrayList<Requests> getRequestsList(String filename) {
	    String data = fetchData(filename + ".txt");
	    String[] splitData = data.split(":");
	    String[] temp;
	    ArrayList<Requests> requestList = new ArrayList<>();
	    for(int i = 0 ; i < splitData.length ; i++){
                temp = splitData[i].split(",");
	        if(temp.length == 4) {
                requestList.add(new systemRequest(Integer.parseInt(temp[0]),
                        Integer.parseInt(temp[1]),Integer.parseInt(temp[2])));
            }
            else if(temp.length == 8){
	            requestList.add(new timeOff(Integer.parseInt(temp[0]),
                        Integer.parseInt(temp[1]), temp[2],
						Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),
                        temp[5],temp[6]));
            }


        }
        return requestList;
    }

    public ArrayList<String> getEmployeeList(){
	    String data = fetchData("employeeList.txt");
	    String[] splitData = data.split(",");
	    ArrayList<String> temp = new ArrayList<>();
	    for(int i = 0 ; i < splitData.length ; i++){
	        temp.add(splitData[i]);
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

	//public Arraylist<Requests> getRequest() throws IOException{ //dateMade,timeMade,requestID,deadline||timeOffType,startDate||"",endDate||"",description||"",userName,,NEXT ENTRY
		//String data = fetchData("request.txt");
		// ON HOLD till request class and sub classes are finished
    //}

	public Boolean addRequest() {
        //redundant in prototype as
		throw new UnsupportedOperationException();
	}

	//public Boolean removeRequest(int requestID) {
        //redundant in prototype
	//}

	//public Boolean setEmployeeAvailability(Employee employee, Week availability) {
        //redundant in prototype
	//}

	public void connectToDatabase() {
        //redundant in prototype
	}

	public String fetchData(String filename)  //file will be written as a single line comma seperated
	{
		try
		{
			BufferedReader inputStream = new BufferedReader(new FileReader(filename));
            String data = inputStream.readLine();
            inputStream.close();
            return data;
		}
		catch (IOException e)
		{
			return null; // null returned when no file is present or empty
		}
	}

	public void writeData(String filename, String data)
    {
        try {
            PrintWriter outputStream = new PrintWriter(new FileWriter(filename));
            outputStream.println(data);
            outputStream.close();
        }
        catch (IOException e) { }
    }
}