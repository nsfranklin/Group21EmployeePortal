import java.time.LocalTime;
import java.util.Calendar;
import java.time.LocalTime;


public class ClockedHours {

    private String userName;
    private int clockedIn;
    private int clockedOut;
    private int overTimeWorked;
    private int timeAbsent;
    private int timeWorked;

    public ClockedHours(String userName, int clockInTime){
        userName = userName;
        clockedIn = clockInTime;
        clockedOut = -1;
        overTimeWorked = -1;
        timeAbsent = -1;
        timeWorked = -1;
    }

    public void clockOut(){
        if(this.clockedOut == -1) {
            this.clockedOut = this.getCurrentTime();
            AssignedDates a = (AssignedDates)SystemManager.getInstance().getCurrentSchedule().getDate((Calendar.getInstance().DAY_OF_WEEK)-1);
            for(int i = 0 ; i < a.getUserAssigned().size() ; i++){
                if(this.userName.equals(a.getUserAssigned().get(i))){
                    int startTime = a.getTimes().get(i)[0];
                    int length = a.getTimes().get(i)[1];
                     if(((this.getCurrentTime() - length - startTime) >= 0) && ((this.clockedIn - startTime) >=0))
                     {
                         this.timeWorked = length;
                         this.overTimeWorked = this.getCurrentTime() - length - startTime + this.clockedIn - startTime;
                         this.timeAbsent = 0;
                     }
                     else if(((this.getCurrentTime() - length - startTime) >= 0) && !((this.clockedIn - startTime) >=0))
                     {
                         this.timeWorked = length - startTime;
                         this.overTimeWorked = this.getCurrentTime() - length - startTime;
                         this.timeAbsent = this.clockedIn - startTime;
                     }
                     else if(!((this.getCurrentTime() - length - startTime) >= 0) && ((this.clockedIn - startTime) >=0))
                     {
                         this.timeWorked = length - (this.getCurrentTime() - length - startTime);
                         this.overTimeWorked = this.clockedIn - startTime;
                         this.timeAbsent = (this.getCurrentTime() - length - startTime);
                     }
                     else
                     {
                         this.timeWorked = length - (this.getCurrentTime() - length - startTime) - (this.clockedIn - startTime);
                         this.overTimeWorked = 0;
                         this.timeAbsent = (this.getCurrentTime() - length - startTime) + (this.clockedIn - startTime);
                     }
                }
            }
        }
    }

    public int getCurrentTime(){
        String[] temp = LocalTime.now().toString().split(":");
        int local = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]); // converts HH:MM form to MM
        return local;
    }

    public int getClockedIn() {
        return this.clockedIn;
    }

    public int getClockedOut() {
        return this.clockedOut;
    }

    public int getHoursAbsent() {
        return this.timeAbsent;
    }

    public int getHoursWorked() {
        return this.timeWorked;
    }

    public int getOverTimeWorked() {
        return this.overTimeWorked;
    }

    public String getUserName() {
        return this.userName;
    }
}
