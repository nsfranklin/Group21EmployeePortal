import java.io.*;

public class DataManager {


	DataManager(){}

	public Employee getEmployee(String employeeID) throws IOException{

	    String data = fetchData(employeeID);
	    String[] splitData = data.split(",");
	    PayrollDetails payroll = new PayrollDetails(Integer.parseInt(split[2]),Integer.parseInt(splitData[3]));
	    Week availability = new Week(Integer.parseInt(splitData[6]),Integer.parseInt(splitData[7]),Integer.parseInt(splitData[8]),Integer.parseInt(splitData[9]),Integer.parseInt(splitData[10]),Integer.parseInt(splitData[11]),Integer.parseInt(splitData[12]),Integer.parseInt(splitData[13]),Integer.parseInt(splitData[14]),Integer.parseInt(splitData[15]),Integer.parseInt(splitData[16]),Integer.parseInt(splitData[17]),Integer.parseInt(splitData[18]),Integer.parseInt(splitData[19]));
        return new Employee(splitData[0],splitData[1],payroll,Boolean.parseBoolean(splitData[4]),availability);
	}

	public Boolean addSchedule(Week s) {
		// TODO - implement DataManager.addSchedule
		throw new UnsupportedOperationException();
	}

	public Week getSchedule(int date) {
		// TODO - implement DataManager.getSchedule
		throw new UnsupportedOperationException();
	}

	public Boolean setEmployeePassword(String name, String password) {
		// TODO - implement DataManager.setEmployeePassword
		throw new UnsupportedOperationException();
	}

	public Boolean addEmployee(String name, String password) {
		// TODO - implement DataManager.addEmployee
		throw new UnsupportedOperationException();
	}

	public Boolean setEmployeeInactive(Employee e) {
		// TODO - implement DataManager.setEmployeeInactive
		throw new UnsupportedOperationException();
	}

	public Boolean addClockInTime(Employee e, int clockIn) {
		// TODO - implement DataManager.addClockInTime
		throw new UnsupportedOperationException();
	}

	public Boolean addClockOutTime(Employee e, int clockOut) {
		// TODO - implement DataManager.addClockOutTime
		throw new UnsupportedOperationException();
	}

	public Boolean addRequest(Request r) {
		// TODO - implement DataManager.addRequest
		throw new UnsupportedOperationException();
	}

	public Boolean removeRequest(int requestID) {
		// TODO - implement DataManager.removeRequest
		throw new UnsupportedOperationException();
	}

	public Boolean setEmployeeAvailability(Employee employee, Week availability) {
		// TODO - implement DataManager.setEmployeeAvailability
		throw new UnsupportedOperationException();
	}

	public void connectToDatabase() { //redundant in prototype
		// TODO - implement DataManager.connectToDatabase
		throw new UnsupportedOperationException();
	}

	public String fetchData(String filename) throws IOException//file will be written as a single
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