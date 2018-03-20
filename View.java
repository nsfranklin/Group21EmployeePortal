import java.util.ArrayList;

public class View {

    private ArrayList<Employee> employeeList;
    private ArrayList<Requests> requestList;
    private ArrayList<Requests> approvedRequestList;
    private Week currentSchedule;
    private ArrayList<ClockedHours> clockedHoursList;
    private ArrayList<Week> futureSchedules;
    private ArrayList<FinalHoursWorked> hoursWorkedLastMonth;
    private SystemManagerController SMC;
    private static View instance;

    private View(){
        this.employeeList = new ArrayList<>();
        this.requestList = new ArrayList<>();
        this.approvedRequestList = new ArrayList<>();
        this.currentSchedule = new Week();
        this.clockedHoursList = new ArrayList<>();
        this.futureSchedules = new ArrayList<>();
        this.hoursWorkedLastMonth = new ArrayList<>();
        this.SMC = null;
    }

    public static View getInstance(){
        if(instance == null){
            instance = new View();
        }
        return instance;
    }

    public void updateDetails(ArrayList<Employee> a, ArrayList<Requests> b, ArrayList<Requests> c, Week d, ArrayList<ClockedHours> clockedHoursList,ArrayList<Week> e, ArrayList<FinalHoursWorked> f){
        this.employeeList = a;
        this.requestList = b;
        this.approvedRequestList = c;
        this.currentSchedule = d;
        this.clockedHoursList = clockedHoursList;
        this.futureSchedules = e;
        this.hoursWorkedLastMonth = f;

    }

    public ArrayList<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeList) {
        this.employeeList = employeList;
    }

    public ArrayList<Requests> getRequestList() {
        return this.requestList;
    }

    public void setRequestList(ArrayList<Requests> requestList) {
        this.requestList = requestList;
    }

    public ArrayList<Requests> getApprovedRequestList() {
        return this.approvedRequestList;
    }

    public void setApprovedRequestList(ArrayList<Requests> approvedRequestList) {
        this.approvedRequestList = approvedRequestList;
    }

    public Week getCurrentSchedule() {
        return this.currentSchedule;
    }

    public void setCurrentSchedule(Week currentSchedule) {
        this.currentSchedule = currentSchedule;
    }

    public ArrayList<ClockedHours> getClockedHoursList() {
        return this.clockedHoursList;
    }

    public void setClockedHoursList(ArrayList<ClockedHours> clockedHoursList) {
        this.clockedHoursList = clockedHoursList;
    }

    public ArrayList<Week> getFutureSchedules() {
        return this.futureSchedules;
    }

    public void setFutureSchedules(ArrayList<Week> futureSchedules) {
        this.futureSchedules = futureSchedules;
    }

    public ArrayList<FinalHoursWorked> getHoursWorkedLastMonth() {
        return this.hoursWorkedLastMonth;
    }

    public void setHoursWorkedLastMonth(ArrayList<FinalHoursWorked> hoursWorkedLastMonth) {
        this.hoursWorkedLastMonth = hoursWorkedLastMonth;
    }

    public void setSMC(SystemManagerController smc){
        this.SMC = smc;
    }

    public SystemManagerController getSMC(){
        return this.SMC;
    }
}
