import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class FinalHoursWorked {

    private ArrayList<Integer> overtimeWorked;
    private ArrayList<Integer> timeWorked;
    private ArrayList<Integer> timeAbsent;
    private ArrayList<String> username;

    public FinalHoursWorked(){
        this.overtimeWorked = new ArrayList<>();
        this.timeAbsent = new ArrayList<>();
        this.timeWorked = new ArrayList<>();
        this.username = new ArrayList<>();
    }

    public void aggregateMonth(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH); //needs past month. so left 0 index unchanged
        ArrayList<String> data = SystemManager.getInstance().getDataManager().getMonthsClockedHours(month, year);
        String[] splitData;
        String[] secondSplit;
        int userPosition = 0;
        for(int i = 0 ; i < data.size() ; i++){
            splitData = data.get(i).split(",,");
            for(int j = 0 ; j < splitData.length ; j++){
                secondSplit = splitData[j].split(",,");
                userPosition =  checkUserNameArray(secondSplit[3]);
                if(userPosition == -1){
                    this.overtimeWorked.add(Integer.parseInt(secondSplit[0]));
                    this.timeAbsent.add(Integer.parseInt(secondSplit[1]));
                    this.timeWorked.add(Integer.parseInt(secondSplit[2]));
                    this.username.add(secondSplit[3]);
                }
                else
                {
                    this.overtimeWorked.set(i, this.overtimeWorked.get(i) + Integer.parseInt(secondSplit[0]));
                    this.timeAbsent.set(i, this.timeAbsent.get(i) + Integer.parseInt(secondSplit[0]));
                    this.timeWorked.set(i, this.timeWorked.get(i) + Integer.parseInt(secondSplit[0]));
                }
            }
        }
    }

    public int checkUserNameArray(String username){
        for(int i = 0 ; i < this.username.size() ; i++){
            if(this.username.get(i).equals(username)) {
                return i;
            }
        }
        return -1;
    }
}
